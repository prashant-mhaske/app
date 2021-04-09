package com.cg.cars.repository;

import java.util.List;

import com.cg.cars.model.Car;

public interface ICarRepository {
	public Car addCar(Car car);
	public Car removeCar(long id);
	public Car updateCar(long id, Car car);
	public Car getCar(long id);
	public List<Car> getAllCars();
	public List<Car> getCarsByLocation();
	public List<Car> getCarsByModel();
	public List<Car> getCarsByBrand();

}
