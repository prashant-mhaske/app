package com.cg.cars.services;

import com.cg.cars.models.User;

/**
*
* @author TEAM 2
* MEMBERS:	Abhishek Sen
* 			Prashant Mhaske
*			Rishabh Gupta
* 			Akshay Talekar
*			Nikhil Nichit
*
*/

public interface IUserService {
	public User signIn(long userId, String password);
	public User signOut(User user);
	public User changePassword(long id, User user);
	
	
}
