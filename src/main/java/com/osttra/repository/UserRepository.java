package com.osttra.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
import org.springframework.stereotype.Repository;
import com.osttra.to.User;
import com.osttra.utils.DbUtils;

@Repository
public class UserRepository {

	public UserRepository() {

		System.out.println("inside UserRepository constr");
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		try {

			Connection connection = DbUtils.getConnection();

			PreparedStatement statement = connection.prepareStatement("insert into user values(?, ?, ?, ?, ?,?)");

			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getCompleteName());
			statement.setString(5, user.getRole());
			statement.setString(6, "false");
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("inside catch of add() of UserRepository...");
			e.printStackTrace();
		}
		
	}

	public User getUser(String username, String password) {

		User user = null;

		try {

			Connection connection = DbUtils.getConnection();

			PreparedStatement statement = connection
					.prepareStatement("select * from user where username = ? and pwd = ?");

			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {

				String completeName = resultSet.getString(3);
				String email = resultSet.getString(4);
				String role = resultSet.getString(5);
				String isApproved=resultSet.getString(6);

				user = new User(username, password, completeName, email, role,isApproved);
			}
		} catch (Exception e) {
			System.out.println("inside catch of getUser(username and password) of UserRepository...");
			e.printStackTrace();
		}

		return user;
	}
	public void updateAdminApprove(User user) {
	try {

		Connection connection = DbUtils.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("update user set admin_approved = ? where username = ?");

		statement.setString(1, "true");
		statement.setString(2, user.getUsername());

		statement.executeUpdate();
	} catch (Exception e) {
		System.out.println("inside catch of update of UserRepository...");
		e.printStackTrace();
	}

}	

	public List<User> getUsers() {

		User user = null;
		List<User> users = new ArrayList<>();

		try {

			Connection connection = DbUtils.getConnection();

			PreparedStatement statement = connection.prepareStatement("select * from user");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String username = resultSet.getString(1);
				String password = resultSet.getString(2);
				String email = resultSet.getString(3);
				String completeName = resultSet.getString(4);
				String role = resultSet.getString(5);
				String isApproved = resultSet.getString(6);
				

				user = new User(username, password, email,completeName, role,isApproved);
               
				users.add(user);

			}
		} catch (Exception e) {
			System.out.println("inside catch of getUsers of UserRepository...");
			e.printStackTrace();
		}
		for(User u:users) {
			System.out.println(u);
		}

		return users;
	}
	public List<User> getStudents() {

		User user = null;
		List<User> students = new ArrayList<>();

		try {

			Connection connection = DbUtils.getConnection();

			PreparedStatement statement = connection.prepareStatement("select * from user where user_role=?");
			
			statement.setString(1, "student");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String username = resultSet.getString(1);
				String password = resultSet.getString(2);
				String completeName = resultSet.getString(3);
				String email = resultSet.getString(4);
				String role = resultSet.getString(5);
				String isApproved = resultSet.getString(6);

				user = new User(username, password, email,completeName, role,isApproved);

				students.add(user);

			}
		} catch (Exception e) {
			System.out.println("inside catch of getUsers of UserRepository...");
			e.printStackTrace();
		}
		

		return students;
	}
	public User getUser(String username) {

		User user = null;

		try {

			Connection connection = DbUtils.getConnection();

			PreparedStatement statement = connection.prepareStatement("select * from user where username = ?");

			statement.setString(1, username);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {

				String password = resultSet.getString(2);
				String completeName = resultSet.getString(3);
				String email = resultSet.getString(4);
				String role = resultSet.getString(5);
				String isApproved = resultSet.getString(6);

				user = new User(username, password, completeName, email, role,isApproved);
			}
		} catch (Exception e) {
			System.out.println("inside catch of getUser(username and password) of UserRepository...");
			e.printStackTrace();
		}

		return user;
	}
	public void delete(String username) {

		try {

			Connection connection = DbUtils.getConnection();

			PreparedStatement statement = connection.prepareStatement("delete from user where username = ?");

			statement.setString(1, username);

			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("inside catch of getUser(username and password) of UserRepository...");
			e.printStackTrace();
		}
	}

	public void update(User user) {
		try {

			Connection connection = DbUtils.getConnection();

			PreparedStatement statement = connection
					.prepareStatement("update user set complete_name = ?, email = ? where username = ?");

			statement.setString(1, user.getCompleteName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getUsername());

			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("inside catch of update of UserRepository...");
			e.printStackTrace();
		}

	}



}
