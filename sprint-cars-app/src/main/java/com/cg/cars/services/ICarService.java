package com.cg.cars.services;

//import java.time.LocalDate;
import java.util.List;

import com.cg.cars.models.Car;

public interface ICarService {
	

	public Car getCarById(long id);
	
//	public Car getCarYear(long id);
	
	public List<Car> getAllCars();
	
	public List<Car> getCarsByLocation(String registrationState);
	
	public List<Car> getCarsByYear(String year);
	
	public List<Car> getCarsByModel(String model);
	
	public List<Car> getCarsByBrand(String brand);
	
	public List<Car> getCarsByPrice(long price);
	
	public Car update(long id, Car car);
	
	public void delete(long id);
	


}
