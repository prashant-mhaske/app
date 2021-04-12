package com.cg.cars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.models.User;
import com.cg.cars.repositories.IUserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserRepository userRepository;

	Boolean isLoggedIn = false;

	@Override
	public User signIn(long userId, String password) {

		User u = userRepository.findById(userId).get();
		if (u.getRole().equals("customer")) {
			if (u.getPassword() == password) {
				isLoggedIn = true;
				return u;
			}

			else {

				isLoggedIn = false;
				return null;

			}
		}

		else if (u.getRole().equals("admin")) {
			isLoggedIn = true;
			return u;
		}

		else

			return null;

	}

	@Override
	public User signOut(User user) {

		if (isLoggedIn) {
			isLoggedIn = false;
			return user;
		}

		return null;
	}

	@Override
	public User changePassword(long id, User user) {
		
		User u =userRepository.findById(id).get();
		
		if(u.getRole().equals("customer"))
		{
			return userRepository.save(user);
		}
		
		return null;
		
	}

}
