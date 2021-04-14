package com.cg.cars.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Embeddable
public class Card {
	
	@Column
	private String name;
	@Column
	private String cardNumber;
	@Column
    private LocalDate expiry;
	@Transient
	String expiryDate;
	@Column
    private int cvv;
    
	public Card() {
	}

	public Card(String name, String number, LocalDate expiry, int cvv) {
		this.name = name;
		this.cardNumber = number;
		this.expiry = expiry;
		this.cvv = cvv;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return cardNumber;
	}

	public void setNumber(String number) {
		this.cardNumber = number;
	}

	public LocalDate getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Card [name=" + name + ", cardNumber=" + cardNumber + ", expiry=" + expiry + ", expiryDate=" + expiryDate
				+ ", cvv=" + cvv + "]";
	}

	
	
    
    
    
}
