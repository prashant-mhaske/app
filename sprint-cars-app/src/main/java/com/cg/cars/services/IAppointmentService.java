package com.cg.cars.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.cg.cars.models.Appointment;

/**
*
* @author TEAM 2
* MEMBERS:	Abhishek Sen
* 			Prashant Mhaske
*			Rishabh Gupta
* 			Akshay Talekar
*			Nikhil Nichit
*
*/

public interface IAppointmentService {

	public Appointment removeAppointment(long id); 
	public Appointment updateAppointment(long id, String location, String inspectionType, LocalDate preferredDate,
			LocalTime preferredTime, long custId, long payId);
	public Appointment getAppointment(long id);
	public List<Appointment> getAllAppointments(); 
	public List<Appointment> getOpenAppointments();
	public Appointment addAppointment(long id, String location, String inspectionType, LocalDate preferredDate,
			LocalTime preferredTime, long custId, long payId);
}
