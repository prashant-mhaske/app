package com.cg.cars.services;

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
	
	@Override
	public Car addCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public Car getCarById(long id) {

		return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Not found"));
	}

	@Override
	public List<Car> getAllCars() {
		car = new ArrayList<>();
		carRepository.findAll().forEach(c -> car.add(c));
		return car;
	}

	@Override
	public List<Car> getCarsByLocation(String registrationState) {
		car = carRepository.findByRegistrationState(registrationState);
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
	public List<Car> getCarsByModelColor(String model, String color) {

		car = carRepository.findByModelColor(model, color);
		return checkForCar(car);
	}

	@Override
	public List<Car> getCarsByBrand(String brand) {

		car = carRepository.findByBrand(brand);
		return checkForCar(car);
	}

	@Override
	public List<Car> getCarsByPrice(double price) {

		car = carRepository.findByPrice(price);
		return checkForCar(car);
	}

	@Override
	public List<Car> getCarsByPriceRange(double start, double end) {

		car =  carRepository.findByPriceRange(start, end);
		return checkForCar(car);
	}

	@Override
	public Car update(long id, Car car) {
		return carRepository.save(car);

	}

	@Override
	public Car delete(long id) {
		Car car1 = getCarById(id);
		carRepository.deleteById(id);
		return car1;
	}

	public static List<Car> checkForCar(List<Car> car) {

		if (car == null)
			throw new CarNotFoundException("Not found");
		return car;
	}


}
