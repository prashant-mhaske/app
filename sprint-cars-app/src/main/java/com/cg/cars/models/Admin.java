package com.cg.cars.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Admin extends User {
	
	@Id
	private long userId;

	public Admin() {
		super();
		
	}

	public Admin(long userId) {
		super();
		super.setRole("admin");
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Admin [userId=" + userId + "]";
	}

	
	
	

}
