package com.cg.cars.repositories;

import java.util.List;

import com.cg.cars.models.Appointment;

public interface IAppointmentRepository {

	public Appointment addAppointment(Appointment appointment);
	public Appointment removeAppointment(long id); 
	public Appointment updateAppointment(long id, Appointment appointment);
	public Appointment getAppointment(long id);
	public List<Appointment> getAllAppointments(); 
	public List<Appointment> getOpenAppointments();
}
