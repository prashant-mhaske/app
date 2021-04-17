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
	public ResponseEntity<Car> saveCar(@RequestBody Car car) { // NOSONAR
		carService.addCar(car);
		return new ResponseEntity<>(carService.addCar(car), HttpStatus.OK);
	}

	@GetMapping("/GetCar/{id}")
	public ResponseEntity<Car> getCar(@PathVariable("id") long id) {
		return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
	}

	@GetMapping("/GetCars")
	public ResponseEntity<List<Car>> getAllCars() {
		return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
	}

	@GetMapping("/GetCars/location/{registrationState}")
	public ResponseEntity<List<Car>> getCarsByLocation(@PathVariable("registrationState") String registrationState) {
		return new ResponseEntity<>(carService.getCarsByLocation(registrationState), HttpStatus.OK);

	}

	@GetMapping("/GetCars/year/{year}")
	public ResponseEntity<List<Car>> getCarsByYear(String year) {
		return new ResponseEntity<>(carService.getCarsByYear(year), HttpStatus.OK);
	}

	@GetMapping("/GetCars/model/{model}")
	public ResponseEntity<List<Car>> getCarsByModel(@PathVariable("model") String model) {
		return new ResponseEntity<>(carService.getCarsByModel(model), HttpStatus.OK);
	}

	@GetMapping("/GetCars/brand/{brand}")
	public ResponseEntity<List<Car>> getCarsByBrand(@PathVariable("brand") String brand) {
		return new ResponseEntity<>(carService.getCarsByBrand(brand), HttpStatus.OK);
	}

	@GetMapping("/GetCars/model-color/{model}/{color}")
	public ResponseEntity<List<Car>> getCarsByModelColor(@PathVariable("model") String model,
			@PathVariable("color") String color) {
		return new ResponseEntity<>(carService.getCarsByModelColor(model, color), HttpStatus.OK);
	}

	@GetMapping("/GetCars/price/{price}")
	public ResponseEntity<List<Car>> getCarsByPrice(@PathVariable("price") double price) {
		return new ResponseEntity<>(carService.getCarsByPrice(price), HttpStatus.OK);
	}

	@GetMapping("/GetCars/price-range/{start}/{end}")
	public ResponseEntity<List<Car>> getCarsByPriceRange(double start, double end) {
		return new ResponseEntity<>(carService.getCarsByPriceRange(start, end), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Car> update(@RequestBody Car car) { // NOSONAR
		return new ResponseEntity<>(carService.update(0, car), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Car> delete(@PathVariable("id") long id) {
		return new ResponseEntity<>(carService.delete(id), HttpStatus.OK);
	}
}
