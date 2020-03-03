package com.andresbiz.my_project.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.andresbiz.my_project.models.User;
import com.andresbiz.my_project.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		User found_user = findByEmail(email);
		
		if(found_user == null) {
			return false;
		}
		else {
			if(BCrypt.checkpw(password, found_user.getPassword())){
				return true;
			}
			else {
				return false;
			}
		}
		
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
		
	}
}
