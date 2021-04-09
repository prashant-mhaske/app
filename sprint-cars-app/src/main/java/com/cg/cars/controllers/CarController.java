package com.cg.cars.controllers;

import java.time.LocalDate;
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

import com.cg.cars.models.Car;
import com.cg.cars.services.CarService;


@RestController
@RequestMapping("/Cars")
public class CarController {

	@Autowired
	CarService carService;
	
	@PostMapping("/add")
	private Car saveCar(@RequestBody Car car)
	{
		carService.addCar(car);
		return car;
	}
	
	@GetMapping("/GetCar/{id}")
	private Car getCar(@PathVariable("id") long id)
	{
		return carService.getCarById(id);
		
	}
	
	@GetMapping("/GetCars")
	public List<Car> getAllCars()
	{
		return carService.getAllCars();
	}
	
	@GetMapping("/GetCars/location/{registrationState}")
	private List<Car> getCarsByLocation(@PathVariable("registrationState") String registrationState)
	{
		return carService.getCarsByLocation(registrationState);
		
	}
	
	@GetMapping("/GetCars/year/{registrationYear}")
	private List<Car> getCarsByYear(@PathVariable("registrationYear") LocalDate registrationYear)
	{
		return carService.getCarsByYear(registrationYear);	
	}
	
	@GetMapping("/GetCars/model/{model}")
	private List<Car> getCarsByModel(@PathVariable("model") String model)
	{
		return carService.getCarsByModel(model);
	}
	
	@GetMapping("/GetCars/brand/{brand}")
	private List<Car> getCarsByBrand(@PathVariable("brand") String brand)
	{
		return carService.getCarsByBrand(brand);
	}
	
	@GetMapping("/GetCars/price/{price}")
	private List<Car> getCarsByPrice(@PathVariable("price") long price)
	{
		return carService.getCarsByPrice(price);	
	}
	
	@PutMapping("/update/{id}")
	private Car update(@PathVariable("id") long id, Car car)
	{
		return carService.update(id, car);
	}
	
	@DeleteMapping("/delete/{id}")
	private void delete(@PathVariable("id") long id)
	{
		carService.delete(id);
	}
}

