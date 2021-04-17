package com.cg.cars.models;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

	public Admin() {
		super();

	}

	public Admin(long userId, String password) {
		super(userId, password, "Admin");
	}

	@Override
	public String toString() {
		return "Admin [userId=" + super.getUserId() + "]";
	}

}
