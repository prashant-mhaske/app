package com.cg.cars.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.models.Appointment;
import com.cg.cars.services.AppointmentService;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {

	@Autowired
	AppointmentService appointService;
	
	@PostMapping("/add/{Id}/{location}/{inspectionType}/{preferredDate}/{preferredTime}/{custId}/{payId}")
	public ResponseEntity<Appointment> addAppointment(@PathVariable ("Id") long id, @PathVariable ("location") String location,
			@PathVariable ("inspectionType") String inspectionType, @RequestParam ("preferredDate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate preferredDate,
			@RequestParam ("LocalTime") @DateTimeFormat(pattern="HH:mm:ss") LocalTime preferredTime, @PathVariable ("custId") long custId, @PathVariable ("payId") long payId)
	{
		
		return new ResponseEntity<>(appointService.addAppointment(id, location, inspectionType, preferredDate, preferredTime, custId, payId), HttpStatus.OK);
	}
	
	@GetMapping("/GetAppointment/{id}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable("id") long id)
	{
 
		return new ResponseEntity<>(appointService.getAppointment(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/GetAppointments")
	public List<Appointment> getAllAppointmets()
	{
		return appointService.getAllAppointments();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Appointment> delete(@PathVariable("id") long id)
	{
		
		return new ResponseEntity<>(appointService.removeAppointment(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{Id}/{location}/{inspectionType}/{preferredDate}/{preferredTime}/{custId}/{payId}")
	public ResponseEntity<Appointment> update(@PathVariable ("Id") long id, @PathVariable ("location") String location,
			@PathVariable ("inspectionType") String inspectionType, @RequestParam ("preferredDate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate preferredDate,
			@RequestParam ("LocalTime") @DateTimeFormat(pattern="HH:mm:ss") LocalTime preferredTime, @PathVariable ("custId") long custId, @PathVariable ("payId") long payId)	//NOSONAR
	{
		
		return new ResponseEntity<>(appointService.updateAppointment(id, location, inspectionType, preferredDate, preferredTime, custId, payId), HttpStatus.OK);
	}
	
	@GetMapping("/GetOpenAppointments")
	public List<Appointment> getOpenAppointments()
	{
		return appointService.getOpenAppointments();
	}
	
	
}
