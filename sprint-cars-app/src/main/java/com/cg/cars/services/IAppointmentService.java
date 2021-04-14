package com.cg.cars.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.cg.cars.models.Appointment;

public interface IAppointmentService {

	//public Appointment addAppointment(Appointment appointment);
	public Appointment removeAppointment(long id); 
	public Appointment updateAppointment(long id, Appointment appointment);
	public Appointment getAppointment(long id);
	public List<Appointment> getAllAppointments(); 
	public List<Appointment> getOpenAppointments();
	public Appointment addAppointment(long id, String location, String inspectionType, LocalDate preferredDate,
			LocalTime preferredTime, long custId, long payId);
}
