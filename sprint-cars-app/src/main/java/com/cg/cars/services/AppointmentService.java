package com.cg.cars.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.AppointmentNotFoundException;
import com.cg.cars.models.Appointment;
import com.cg.cars.models.Customer;
import com.cg.cars.models.Payment;
import com.cg.cars.repositories.IAppointmentRepository;

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

@Service
public class AppointmentService implements IAppointmentService {
	
	@Autowired 
	IAppointmentRepository appointmentRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	PaymentService paymentService;
	
	

	
	@Override
	public Appointment addAppointment(long id, String location, String inspectionType, LocalDate preferredDate,
			LocalTime preferredTime, long custId, long payId) {
		
		
		
		Customer cust = customerService.getCustomer(custId);
		
		Payment pay = paymentService.getPaymentDetails(payId);
		
		
		Appointment appointment = new Appointment(id, location, inspectionType, preferredDate, preferredTime, cust, pay);
		
		return appointmentRepository.save(appointment);
	}
	
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
	public Appointment updateAppointment(long id, String location, String inspectionType, LocalDate preferredDate,
			LocalTime preferredTime, long custId, long payId) {
		
		Appointment appointment=appointmentRepository.findById(id)
				.orElseThrow(() ->new AppointmentNotFoundException("Appointment Details Not Avialable"));
		
		Customer cust = customerService.getCustomer(custId);
		Payment pay = paymentService.getPaymentDetails(payId);
		appointment.setLocation(location);
		appointment.setInspectionType(inspectionType);
		appointment.setPreferredDate(preferredDate);
		appointment.setPreferredTime(preferredTime);
		appointment.setCustomer(cust);
		appointment.setPayment(pay);
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
		return appointmentRepository.findByInspectionType("open");
	}

}
