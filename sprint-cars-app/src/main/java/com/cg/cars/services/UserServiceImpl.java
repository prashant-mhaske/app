package com.cg.cars.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.cars.models.User;
import com.cg.cars.repositories.IUserRepository;

public class UserServiceImpl implements IUserService
{
	@Autowired
	IUserRepository userRepository;

	@Override
	public User signIn(User user) {
		
		return null;
	}

	@Override
	public User signOut(User user) {
		
		return null;
	}

	@Override
	public User changePassword(long id, User user) {
		
		return null;
	}

}
