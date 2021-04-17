package com.cg.cars.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.exceptions.CarNotFoundException;
import com.cg.cars.models.Car;

import com.cg.cars.repositories.ICarRepository;

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
public class ICarServiceImpl implements ICarService {

	List<Car> car;

	@Autowired
	ICarRepository carRepository;

	/*
	 * Add car details in database.
	 */
	@Override
	public Car addCar(Car car) {
		return carRepository.save(car);
	}

	/*
	 * Retrieving car information by car Id.
	 */
	@Override
	public Car getCarById(long id) {

		return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Not found"));
	}

	/*
	 * Get all cars details from database.
	 */
	@Override
	public List<Car> getAllCars() {
		car = new ArrayList<>();
		carRepository.findAll().forEach(c -> car.add(c));
		return car;
	}

	/*
	 * Retrieving car information by registration state.
	 */
	@Override
	public List<Car> getCarsByLocation(String registrationState) {
		car = carRepository.findByRegistrationState(registrationState);
		return checkForCar(car);
	}

	/*
	 * Retrieving car information by registration year.
	 */
	@Override
	public List<Car> getCarsByYear(String year) {
		car = carRepository.findByYear(year);
		return checkForCar(car);
	}

	/*
	 * Retrieving car information by Model name.
	 */
	@Override
	public List<Car> getCarsByModel(String model) {
		car = carRepository.findByModel(model);
		return checkForCar(car);
	}

	/*
	 * Retrieving car information by Model and color.
	 */
	@Override
	public List<Car> getCarsByModelColor(String model, String color) {

		car = carRepository.findByModelColor(model, color);
		return checkForCar(car);
	}

	/*
	 * Retrieving car information by Brand name.
	 */
	@Override
	public List<Car> getCarsByBrand(String brand) {

		car = carRepository.findByBrand(brand);
		return checkForCar(car);
	}

	/*
	 * Retrieving car information by car price.
	 */
	@Override
	public List<Car> getCarsByPrice(double price) {

		car = carRepository.findByPrice(price);
		return checkForCar(car);
	}

	/*
	 * Retrieving and sorting car information by car price range.
	 */
	@Override
	public List<Car> getCarsByPriceRange(double start, double end) {

		car = carRepository.findByPriceRange(start, end);
		return checkForCar(car);
	}

	/*
	 * Update car information using car id.
	 */
	@Override
	public Car update(long id, Car car) {
		return carRepository.save(car);
	}

	/*
	 * Delete car information from database using car Id.
	 */
	@Override
	public Car delete(long id) {
		Car car1 = getCarById(id);
		carRepository.deleteById(id);
		return car1;
	}

	/*
	 * To check whether car object is null or not for exception.
	 */
	public static List<Car> checkForCar(List<Car> car) {

		if (car.isEmpty())
			throw new CarNotFoundException("Not found any result...");
		return car;
	}

}
