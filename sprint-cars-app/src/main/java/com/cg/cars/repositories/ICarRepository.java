package com.cg.cars.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.cars.models.Car;

public interface ICarRepository extends JpaRepository<Car, Long> {
public List<Car> findByRegistrationState(String registrationState);
	
	public List<Car> findByModel(String model);
	
	public List<Car> findByBrand(String brand);
	
	public List<Car> findByPrice(long price);
	
	@Query("select c from Car c where to_char(registrationYear,'yyyy') = :year")
	public List<Car> findByYear(@Param(value = "year") String year);
	
}
