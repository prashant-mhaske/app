package com.cg.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment)
	{
		Appointment a = appointService.addAppointment(appointment);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@GetMapping("/GetAppointment/{id}")
	private ResponseEntity<Appointment> getAppointment(@PathVariable("id") long id)
	{
		Appointment a = appointService.getAppointment(id);
		return new ResponseEntity<>(a, HttpStatus.OK);
		
	}
	
	@GetMapping("/GetAppointments")
	public List<Appointment> getAllAppointmets()
	{
		return appointService.getAllAppointments();
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<Appointment> delete(@PathVariable("id") long id)
	{
		Appointment a = appointService.removeAppointment(id);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	private ResponseEntity<Appointment> update(@PathVariable("id") long id, Appointment appointment)
	{
		Appointment a = appointService.updateAppointment(id, appointment);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@GetMapping("/GetOpenAppointments")
	private List<Appointment> getOpenAppointments()
	{
		return appointService.getOpenAppointments();
	}
	
	
}
