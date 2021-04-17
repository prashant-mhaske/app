package com.cg.cars.repositories;

import org.springframework.data.repository.CrudRepository;

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

public interface IUserRepository extends CrudRepository<User, Long>{

	//String getPassword(User user);
//	public User signIn(User user);
//	public User signOut(User user);
//	public User changePassword(long id, User user);




}
