package com.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.iservice.IUser;
import com.app.model.User;
import com.app.repo.UserRepository;

@Service
public class UserServiceImpl implements IUser {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return  userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return  userRepository.save(user);
	}

	@Override
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "delete user";
	}

	@Override
	public User getUser(int id) {
		return  userRepository.findById(id).isPresent()?
				userRepository.findById(id).get():null;
	}

	@Override
	public List<User> getAllUsers() {
		return  userRepository.findAll();
	}
	
	@Override
	public  User findByUserEmail(String email) {
		return userRepository.findByEmail(email).isPresent()?
				userRepository.findByEmail(email).get():null;
	}

}
