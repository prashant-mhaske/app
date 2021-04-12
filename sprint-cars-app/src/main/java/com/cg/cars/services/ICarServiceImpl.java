package com.cg.cars.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.models.Car;

import com.cg.cars.repositories.ICarRepository;

@Service
public class ICarServiceImpl implements ICarService {

	@Autowired
	ICarRepository carRepository;

	public void addCar(Car car) {
		carRepository.save(car);

	}
	

	@Override
	public Car getCarById(long id) {
		return carRepository.findById(id).get();
	}


	@Override
	public List<Car> getAllCars() {
		List<Car> car = new ArrayList<>();
		carRepository.findAll().forEach(car1 -> car.add(car1));
		return car;
	}

	@Override
	public List<Car> getCarsByLocation(String registrationState) {

		return carRepository.findByRegistrationState(registrationState);

	}
	
	@Override
	public List<Car> getCarsByYear(LocalDate registrationYear) {

		return carRepository.findByRegistrationYear(registrationYear);
	}
	
	@Override
	public List<Car> getCarsByModel(String model) {

		return carRepository.findByModel(model);
	}
	
	@Override
	public List<Car> getCarsByBrand(String brand) {

		return carRepository.findByBrand(brand);
	}
	
	@Override
	public List<Car> getCarsByPrice(long price) {

		return carRepository.findByPrice(price);
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

}
