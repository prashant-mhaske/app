package com.cg.cars.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
	private long appointmentId;
	private String location;
	private String inspectionType;
	private LocalDate preferredDate;
	private LocalTime preferredTime;
	private Customer customer;
	private Payment payment;

}
