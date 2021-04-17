package com.cg.cars.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String type;
	@Column
	private String status;
	
	@Embedded
	private Card card;
	public Payment() {
	}
	public Payment(long id, String type, String status, Card card) {
		this.id = id;
		this.type = type;
		this.status = status;
		this.card = card;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}
	
	
}
