package com.cg.cars.models;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Car{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String brand;
	
	@Column
	private String model;
	
	@Column
	private String color;
	
	@Column
	private String variant;
	
	@Column
	private double price;
	
	@Column
	private LocalDate registrationYear;

	@Column
	private String registrationState;

	public Car() {
		super();
	}

	public Car(long id, String brand, String model,String color, String variant, double price,LocalDate registrationYear,
			String registrationState) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.variant = variant;
		this.price = price;
		this.registrationYear = registrationYear;
		this.registrationState = registrationState;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(LocalDate registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getRegistrationState() {
		return registrationState;
	}

	public void setRegistrationState(String registrationState) {
		this.registrationState = registrationState;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", color=" + color + ", variant=" + variant
				+ ", price=" + price + ", registrationYear=" + registrationYear + ", registrationState="
				+ registrationState + "]";
	}

}
