package com.osttra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.osttra.service.UserService;
import com.osttra.to.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	public UserController() {
		System.out.println("inside UserController constr...");
	}
	
	@PostMapping("/register")
	public String register(User user) {

		System.out.println("inside register()..." + user);

		userService.register(user);

		return "index";
	}
	@PostMapping("/login")
	public ModelAndView userLogin(String username, String password, HttpServletRequest request) {
		
		User user=userService.login(username,password);
		
		ModelAndView modelAndView=null;
		if(user!=null) {
			
			if (user.getRole().equals("admin")) {
				System.out.println("inside role equals admin");
			    userService.setApprove(user);

 			HttpSession session=request.getSession();

 			List<User> users = userService.getUsers();
			session.setAttribute("users", users);
			}
			if(user.getIsApproved().equals("true")) {
				if (user.getRole().equals("teacher")) {
					 System.out.print("inside teacher role part");
					 HttpSession session=request.getSession();
					List<User> students = userService.getStudents();
					session.setAttribute("students", students);

				}
				System.out.print("inside is approval true");
				modelAndView = new ModelAndView("welcome_page");
	 			HttpSession session=request.getSession();
	 			session.setAttribute("user", user);
			}else {
				modelAndView = new ModelAndView("index");
				modelAndView.addObject("errorApproveMsg", "Please Wait, you are not approved by admin yet!!");
			}
		} else {
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("errorMessage", "Wrong Credentials, please try again!!");
		}

		return modelAndView;
	}
	@GetMapping(value="/welcome_page/approved/{username}")
public ModelAndView updateApproveStatus(@PathVariable String username, HttpServletRequest request) {
	User user1 = userService.getUser(username);
	System.out.println("inside update approval "+user1.toString());
      userService.updateAdminApproval(user1);
     HttpSession session = request.getSession(false);
     session.setAttribute("user1", user1);
    List<User> users = userService.getUsers();
	session.setAttribute("users", users);
	ModelAndView modelAndView = new ModelAndView("welcome_page");
	modelAndView.addObject("approveSuccessMsg", "User successfully approved for login");
	
   return modelAndView;
	}

	
	@GetMapping("/updatePage/{username}")
	public ModelAndView updatePage(@PathVariable String username, HttpServletRequest request) {
		System.out.println("Userame is "+username);
		
		ModelAndView modelAndView = null;
		
		HttpSession session = request.getSession(false);
		
		
		if( session != null ) {
			modelAndView = new ModelAndView("update_page");
		}
		else {
			modelAndView = new ModelAndView("index");
		}
		
		
		
		return modelAndView;
			
	}
	
	@GetMapping("/admin/updatePage/{username}")
	public ModelAndView updateUserPage(@PathVariable String username, HttpServletRequest request) {
		System.out.println("Username is "+username);
		
		ModelAndView modelAndView = null;
		User userUpdate=userService.getUser(username);
		HttpSession session = request.getSession(false);
		session.setAttribute("user", userUpdate);
		
		if( session != null ) {
			modelAndView = new ModelAndView("update_page");
		}
		else {
			modelAndView = new ModelAndView("index");
		}
		
		
		return modelAndView;
			
	}
	
	@PostMapping("/admin/update/{username}")
	public ModelAndView update(@PathVariable String username, HttpServletRequest request) {
		
		System.out.println("inside update put"+user.toString());
		User userUpdate=userService.getUser(username);
	userService.update(userUpdate);
		
		HttpSession session = request.getSession();

	List<User> users = userService.getUsers();
	session.setAttribute("users", users);
		ModelAndView modelAndView = new ModelAndView("welcome_page");
		modelAndView.addObject("updateSuccessMsg", "Profile is updated successfully");
		 
		return modelAndView;}
	
	@PostMapping("/update")
	public ModelAndView update(User user, HttpServletRequest request) {
		
		System.out.println("inside update put"+user.toString());

		
		userService.update(user);
		
		HttpSession session = request.getSession(false);
		
		User oldSessionUser = ( User )session.getAttribute("user");
		
		String password = oldSessionUser.getPassword();
		String role = oldSessionUser.getRole();
		
		user.setPassword(password);   user.setRole(role);
		
		session.setAttribute("user", user);
		
		ModelAndView modelAndView = new ModelAndView("welcome_page");
		modelAndView.addObject("updateSuccessMsg", "Your Profile is updated successfully");
		
		return modelAndView;}

@GetMapping("/delete/{username}")
public ModelAndView delete(@PathVariable String username, HttpServletRequest request) {

	System.out.println(username);

	ModelAndView modelAndView = null;

	HttpSession session = request.getSession(false);

	if (session != null) {
		
		userService.delete(username);

		if (((User) session.getAttribute("user")).getRole().equals("admin")) {

			modelAndView = new ModelAndView("welcome_page");
			List<User> users = userService.getUsers();
			session.setAttribute("users", users);
		} else {
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("deleteSucessMsg", "Your Account has been deleted successfully!!");
		}
	} else {
		System.out.println("inside else of delete...");
		modelAndView = new ModelAndView("index");
		modelAndView.addObject("deleteErrorMsg", "You are not authenticated, please login first!!");
	}

	return modelAndView;
}
@GetMapping("/logout")
public ModelAndView logout(HttpServletRequest request) {
     
	System.out.println("inside logout");
	ModelAndView modelAndView =  new ModelAndView("index");

	HttpSession session = request.getSession(false);
	System.out.println("Session is while logout "+session);

	if (session != null) {

		session.invalidate();
		
		modelAndView.addObject("logoutMessage", "Logged-out successfully..");
	} else {

		modelAndView.addObject("errorMessage", "You were never logged-in, please login first to logout!!");
	}

	return modelAndView;
}

}