package com.cg.cars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.UserNotFoundException;
import com.cg.cars.models.User;
import com.cg.cars.repositories.IUserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserRepository userRepository;

	

	@Override
	public User signIn(long userId, String password) {

		User u = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found !!"));
		if (u.getRole().equals("Customer")) {
			if (u.getPassword().equals(password)) {
				u.isLoggedIn = true;
				return u;
			}

			else {

				u.isLoggedIn = false;
				return null;

			}
		}

		else if (u.getRole().equals("Admin")) {
			u.isLoggedIn = true;
			return u;
		}

		else

			return null;

	}

	@Override
	public User signOut(User user) {

		if (user.isLoggedIn) {
			user.isLoggedIn = false;
			return user;
		}

		return null;
	}

	@Override
	public User changePassword(long id, User user) {

		User u = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found !!"));
		if (u.getRole().equals("customer")) {
			return userRepository.save(user);
		}

		return null;

	}

}
