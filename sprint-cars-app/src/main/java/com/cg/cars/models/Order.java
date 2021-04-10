package com.cg.cars.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private double amount;
	
	@Column
	private LocalDate billingDate;
	
	@OneToOne
	private Customer customer;
	
	public Order() {
		
	}

	public Order(long id, double amount, LocalDate billingDate, Customer customer) {
		super();
		this.id = id;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", amount=" + amount + ", billingDate=" + billingDate + ", customer=" + customer
				+ "]";
	}
	
	

}