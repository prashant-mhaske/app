package com.cg.cars.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cg.cars.models.User;

public interface IUserRepository extends CrudRepository<User, Long>{
//	public User signIn(User user);
//	public User signOut(User user);
//	public User changePassword(long id, User user);

}
