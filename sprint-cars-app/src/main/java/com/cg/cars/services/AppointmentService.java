package com.cg.cars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.models.Appointment;
import com.cg.cars.repositories.IAppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService {
	
	@Autowired 
	IAppointmentRepository appointmentRepository;

	@Override
	public Appointment addAppointment(Appointment appointment) {
		
		return null;
	}

	@Override
	public Appointment removeAppointment(long id) {
		Appointment appointment=appointmentRepository.findById(id).get();
		appointmentRepository.deleteById(id);
		return appointment;
	}

	@Override
	public Appointment updateAppointment(long id, Appointment appointment) {
		appointmentRepository.save(appointment);
		return appointment;
		
	}

	@Override
	public Appointment getAppointment(long id) {
		return appointmentRepository.findById(id).get();
		
	}

	@Override
	public List<Appointment> getAllAppointments() {
		List<Appointment> appoinment = new ArrayList<>();
		appointmentRepository.findAll().forEach(a -> appoinment.add(a));
		return appoinment;
	
	}

	@Override
	public List<Appointment> getOpenAppointments() {
		//List<Appointment> appointment = appointmentRepository.findByInspectionType().forEach(a -> a.getInspectionType().equals("open"));
		return null;
	}

}
