package com.cg.cars.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.cars.models.Appointment;
import com.cg.cars.repositories.IAppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService {
	
	@Autowired 
	IAppointmentRepository appointmentRepository;

	@Override
	public Appointment addAppointment(Appointment appointment) {
		
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment removeAppointment(long id) {
		Appointment appointment= getAppointment(id);
		appointmentRepository.deleteById(id);
		return appointment;
	}

	@Override
	public Appointment updateAppointment(long id, Appointment appointment) {
		return appointmentRepository.save(appointment);
		 
		
	}

	@Override
	public Appointment getAppointment(long id) {
		return appointmentRepository.findById(id)
				.orElseThrow(()-> new com.cg.cars.exceptions.AppointmentNotFoundException("Appointment Details Not Avialable"));
				
		
	}

	@Override
	public List<Appointment> getAllAppointments() {
		List<Appointment> appoinment = new ArrayList<>();
		appointmentRepository.findAll().forEach(a -> appoinment.add(a));
		return appoinment;
	
	}

	@Override
	public List<Appointment> getOpenAppointments() {
		List<Appointment> appointments=appointmentRepository.findByInspectionType("open");
//		List<Appointment> appointments = appointmentRepository.findByInspectionType()
//				.stream().filter(a ->a.getInspectionType().equals("open"))
//				.collect(Collectors.toList());
		return appointments;
	}

}
