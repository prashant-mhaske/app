package com.cg.cars.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private LocalDate billingDate;
	
	@Column
	private String status;
	
	@OneToOne
	private Customer customer;
	
	@ManyToMany(mappedBy = "order")
	private List<Car> car=new ArrayList<>();
	
	public Order() {	
	}
	
	public Order(long id, LocalDate billingDate, Customer customer, List<Car> car) {
		super();
		this.id = id;
		this.billingDate = billingDate;
		this.customer = customer;
		this.car = car;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Car> getCar() {
		return car;
	}

	public void setCar(List<Car> car) {
		this.car = car;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", billingDate=" + billingDate + ", customer=" + customer + ", car=" + car + "]";
	}
}