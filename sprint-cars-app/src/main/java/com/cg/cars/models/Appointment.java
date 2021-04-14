package com.cg.cars.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;


@Entity
@Table
public class Appointment {
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String location;
	@Column
	private String inspectionType;
	@Column
	private LocalDate preferredDate;
	@Column
	private LocalTime preferredTime;
	
	@OneToOne
	private Customer customer;

	@OneToOne
	private Payment payment;
	
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(long id, String location, String inspectionType, LocalDate preferredDate,
			LocalTime preferredTime, Customer customer, Payment payment) {
		super();
		id = id;
		this.location = location;
		this.inspectionType = inspectionType;
		this.preferredDate = preferredDate;
		this.preferredTime = preferredTime;
		this.customer = customer;
		this.payment = payment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}

	public LocalDate getPreferredDate() {
		return preferredDate;
	}

	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}

	public LocalTime getPreferredTime() {
		return preferredTime;
	}

	public void setPreferredTime(LocalTime preferredTime) {
		this.preferredTime = preferredTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", location=" + location + ", inspectionType=" + inspectionType
				+ ", preferredDate=" + preferredDate + ", preferredTime=" + preferredTime + ", customer=" + customer
				+ ", payment=" + payment + "]";
	}

	

}
