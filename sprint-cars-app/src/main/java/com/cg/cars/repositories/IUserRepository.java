package com.cg.cars.repositories;

import com.cg.cars.models.User;

public interface IUserRepository {
	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(long id, User user);

}
