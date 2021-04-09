package com.cg.cars.repository;

import com.cg.cars.model.User;

public interface IUserRepository {
	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(long id, User user);

}
