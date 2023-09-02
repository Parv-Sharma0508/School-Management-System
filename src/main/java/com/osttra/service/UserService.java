package com.osttra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osttra.repository.UserRepository;
import com.osttra.to.User;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;


	public void register(User user) {
		
		userRepository.addUser(user);	
	}

	public User login(String username, String password) {

		return userRepository.getUser(username, password);
	}
	
	public void setApprove(User user) {
		userRepository.updateAdminApprove(user);
	}
    public void update(User user) {
    	
		userRepository.update(user);
	}
	public void updateAdminApproval(User user) {
		userRepository.updateAdminApprove(user);
	}
	
	public User getUser(String username) {
		
		User user = userRepository.getUser(username);
		
		return user;
	}
	
	
//	public List<User> getUsers() {
//		// TODO Auto-generated method stub
//		System.out.print("inside service get users");
//		return userRepository.getUsers();
//	}

	public List<User> getStudents() {
		// TODO Auto-generated method stub
		return userRepository.getStudents();
	}
//
	public void delete(String username) {
		// TODO Auto-generated method stub
		userRepository.delete(username);

	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		System.out.print("inside service get users");
		return userRepository.getUsers();
	}
	
	
}