package com.cg.cars.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	private long userId;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
//	@OneToOne
//	private Customer customerUser;

	public User() {
		super();
		
	}

	public User(long userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		//this.customerUser = customerUser;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

//	public Customer getCustomerUser() {
//		return customerUser;
//	}
//
//	public void setCustomerUser(Customer customerUser) {
//		this.customerUser = customerUser;
//	}

	

}