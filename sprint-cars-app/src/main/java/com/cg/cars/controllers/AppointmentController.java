package com.cg.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.models.Appointment;
import com.cg.cars.services.AppointmentService;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {

	@Autowired
	AppointmentService appointService;
	
	@PostMapping("/add")
	private Appointment saveAppointment(@RequestBody Appointment appointment)
	{
		appointService.addAppointment(appointment);
		return appointment;
	}
	
	@GetMapping("/GetAppointment/{id}")
	private Appointment getAppointment(@PathVariable("id") long id)
	{
		return appointService.getAppointment(id);
		
	}
	
	@GetMapping("/GetAppointments")
	public List<Appointment> getAllAppointmets()
	{
		return appointService.getAllAppointments();
	}
	
	@DeleteMapping("/delete/{id}")
	private void delete(@PathVariable("id") long id)
	{
		appointService.removeAppointment(id);
	}
	
	@PutMapping("/update/{id}")
	private Appointment update(@PathVariable("id") long id, Appointment appointment)
	{
		return appointService.updateAppointment(id, appointment);
	}
	
	@GetMapping("/GetOpenAppointments")
	private List<Appointment> getOpenAppointments()
	{
		return appointService.getOpenAppointments();
	}
	
	
}
