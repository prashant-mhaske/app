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

import com.cg.cars.models.Car;
import com.cg.cars.services.ICarServiceImpl;

@RestController
@RequestMapping("/Cars")
public class CarController {

	@Autowired
	ICarServiceImpl carService;

	@PostMapping("/add")
	private ResponseEntity<Car> saveCar(@RequestBody Car car) {
		carService.addCar(car);
		return new ResponseEntity<Car>(carService.addCar(car), HttpStatus.OK);
	}

	@GetMapping("/GetCar/{id}")
	private ResponseEntity<Car> getCar(@PathVariable("id") long id) {
		return new ResponseEntity<Car>(carService.getCarById(id), HttpStatus.OK);
	}

	@GetMapping("/GetCars")
	public ResponseEntity<List<Car>> getAllCars() {
		return new ResponseEntity<List<Car>>(carService.getAllCars(), HttpStatus.OK);
	}

	@GetMapping("/GetCars/location/{registrationState}")
	private ResponseEntity<List<Car>> getCarsByLocation(@PathVariable("registrationState") String registrationState) {
		return new ResponseEntity<List<Car>>(carService.getCarsByLocation(registrationState), HttpStatus.OK);

	}

	@GetMapping("/GetCars/year/{year}")
	private ResponseEntity<List<Car>> getCarsByYear(String year) {
		return new ResponseEntity<List<Car>>(carService.getCarsByYear(year), HttpStatus.OK);
	}

	@GetMapping("/GetCars/model/{model}")
	private ResponseEntity<List<Car>> getCarsByModel(@PathVariable("model") String model) {
		return new ResponseEntity<List<Car>>(carService.getCarsByModel(model), HttpStatus.OK);
	}

	@GetMapping("/GetCars/brand/{brand}")
	private ResponseEntity<List<Car>> getCarsByBrand(@PathVariable("brand") String brand) {
		return new ResponseEntity<List<Car>>(carService.getCarsByBrand(brand), HttpStatus.OK);
	}

	@GetMapping("/GetCars/model-color/{model}/{color}")
	private ResponseEntity<List<Car>> getCarsByModelColor(@PathVariable("model") String model,
			@PathVariable("color") String color) {
		return new ResponseEntity<List<Car>>(carService.getCarsByModelColor(model, color), HttpStatus.OK);
	}

	@GetMapping("/GetCars/price/{price}")
	private ResponseEntity<List<Car>> getCarsByPrice(@PathVariable("price") double price) {
		return new ResponseEntity<List<Car>>(carService.getCarsByPrice(price), HttpStatus.OK);
	}

	@GetMapping("/GetCars/price-range/{start}/{end}")
	private ResponseEntity<List<Car>> getCarsByPriceRange(double start, double end) {
		return new ResponseEntity<List<Car>>(carService.getCarsByPriceRange(start, end), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	private ResponseEntity<Car> update(@PathVariable("id") long id, @RequestBody Car car) {
		return new ResponseEntity<Car>(carService.update(id, car), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	private ResponseEntity<Car> delete(@PathVariable("id") long id) {
		return new ResponseEntity<Car>(carService.delete(id), HttpStatus.OK);
	}
}
