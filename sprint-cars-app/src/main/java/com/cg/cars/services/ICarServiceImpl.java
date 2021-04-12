package com.cg.cars.services;


//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.CarNotFoundException;
import com.cg.cars.models.Car;

import com.cg.cars.repositories.ICarRepository;

@Service
public class ICarServiceImpl implements ICarService {
	
	List<Car> car;
	@Autowired
	ICarRepository carRepository;

	public void addCar(Car car) {
		carRepository.save(car);
	}
	

	@Override
	public Car getCarById(long id) {
//		return carRepository.findById(id).get();
		return carRepository.findById(id).orElseThrow(()-> new CarNotFoundException("Not found"));
	}


	@Override
	public List<Car> getAllCars() {
		List<Car> car = new ArrayList<>();
		carRepository.findAll().forEach(car1 -> car.add(car1));
		return car;
	}

	@Override
	public List<Car> getCarsByLocation(String registrationState) {
		car=carRepository.findByRegistrationState(registrationState);
		return checkForCar(car);
	}
	
	@Override
	public List<Car> getCarsByYear(String year) {
		car = carRepository.findByYear(year);
		return checkForCar(car); 
	}

	@Override
	public List<Car> getCarsByModel(String model) {
		car = carRepository.findByModel(model);
		return checkForCar(car);
		
	}
	
	@Override
	public List<Car> getCarsByBrand(String brand) {

		car = carRepository.findByBrand(brand);
		return checkForCar(car);
	}
	
	@Override
	public List<Car> getCarsByPrice(long price) {

		car = carRepository.findByPrice(price);
		return checkForCar(car);
	}
	
	@Override
	public Car update(long id, Car car) {

		Car car1 = carRepository.findById(id).get();
		car1 = car;
		return car1;
	}

	@Override
	public void delete(long id) {

		carRepository.deleteById(id);
	}
	
	
	public static List<Car> checkForCar(List<Car> car) {
		
		if(car==null)
			throw new CarNotFoundException("Not found");
		return car;
	}

}
