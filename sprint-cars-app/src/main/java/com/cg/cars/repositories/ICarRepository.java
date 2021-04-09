package com.cg.cars.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cars.models.Car;

public interface ICarRepository extends JpaRepository<Car, Long> {
public List<Car> findByRegistrationState(String registrationState);
	
	public List<Car> findByModel(String model);
	
	public List<Car> findByBrand(String brand);
	
	public List<Car> findByPrice(long price);
	
	public List<Car> findByRegistrationYear(LocalDate registrationYear);
	
	public Car updateById(long id);

}
