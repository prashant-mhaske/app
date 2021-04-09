package com.cg.cars.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.models.Car;
import com.cg.cars.repositories.CarRepository;


@Service
public class CarService {
	


	@Autowired
	CarRepository carRepository;
	
	public void addCar(Car car)
	{
		carRepository.save(car);
		
	}
	
	public Car removeCar(long id)
	{
		return null;
		
	}
	
	public Car updateCar(long id, Car car)
	{
		return null;
	}
	
	public Car getCarById(long id) 
	{	
		return carRepository.findById(id).get();
	}
	
	public Car getCarYear(long id) 
	{	
		return carRepository.findById(id).get();
	}
	
	public List<Car> getAllCars()
	{
		List<Car> car = new ArrayList<>();
		carRepository.findAll().forEach(car1->car.add(car1));
		return car;
	}
	
	public List<Car> getCarsByLocation(String registrationState)
	{
		
		return carRepository.findByRegistrationState(registrationState);
		 
		
	}
	
	public List<Car> getCarsByYear(LocalDate registrationYear) 
  {
	
		return carRepository.findByRegistrationYear(registrationYear);
	}

	public List<Car> getCarsByModel(String model)
  {
		
		return carRepository.findByModel(model);
	}

	public List<Car> getCarsByBrand(String brand)
  {
		
		return carRepository.findByBrand(brand);
	}

	public List<Car> getCarsByPrice(long price) 
  {
		
		return carRepository.findByPrice(price);
	}

	public Car update(long id, Car car) 
  {
		
		Car car1 = carRepository.findById(id).get();
		car1 = car;
		return car1;
	}

	public void delete(long id) 
  {
		
		carRepository.deleteById(id);
	}

	
	
	
}
