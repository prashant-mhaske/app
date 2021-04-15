package com.cg.cars.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Customer extends User {
	
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String contactNo;
	
	@Column
	private  LocalDate dob;
	
	@Embedded
	private Address address;
	
	
	public Customer() {
		//super();
		
	}


	public Customer(long userId, String password, String name, String email, String contactNo, LocalDate dob, Address address) {
		super(userId,password,"Customer");
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [userId=" + super.getUserId() + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + address + "]";
	}
	
	
	
	
	
	

}