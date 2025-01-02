package org.jsp.springbootecholink.service;

import org.jsp.springbootecholink.model.User;
import org.jsp.springbootecholink.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User getUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
}
