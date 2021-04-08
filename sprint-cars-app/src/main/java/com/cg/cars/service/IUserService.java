package com.cg.cars.service;

import com.cg.cars.model.User;

public interface IUserService {
	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(long id, User user);

}
