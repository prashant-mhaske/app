package com.cg.cars.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author TEAM 2
 * MEMBERS: Abhishek Sen
 * 			Prashant Mhaske
 * 			Rishabh Gupta
 * 			Akshay Talekar
 * 			Nikhil Nichit
 *
 */

@Embeddable
public class Address {
	
	@Column
	private int doorNo;
	
	@Column
	private String street;
	
	@Column
	private String area;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private int pincode;
 
	
	public Address() {
		super();
		
	}

	public Address(int doorNo, String street, String area, String city, String state, int pincode) {
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + "]";
	}

	
	
		
	
	
}
