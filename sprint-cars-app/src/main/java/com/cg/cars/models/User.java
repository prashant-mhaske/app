package com.cg.cars.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User {

	@Column
	private int userId;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	private Customer customerUser;

	public User() {
		super();
		
	}

	public User(int userId, String password, String role, Customer customerUser) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.customerUser = customerUser;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	public Customer getCustomerUser() {
		return customerUser;
	}

	public void setCustomerUser(Customer customerUser) {
		this.customerUser = customerUser;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + ", customerUser=" + customerUser
				+ "]";
	}

}