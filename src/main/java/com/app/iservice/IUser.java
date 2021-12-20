package com.app.iservice;

import java.util.List;

import com.app.model.User;

public interface IUser {
	User saveUser(User user);
	User updateUser(User user);
	String deleteUser(int id);
	User getUser(int id);
	List<User> getAllUsers();
	User findByUserEmail(String email);

}
