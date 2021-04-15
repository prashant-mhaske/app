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
	
	public List<Car> findByPrice(double price);
	
	@Query("select c from Car c where to_char(registrationYear,'yyyy') = :year")
	public List<Car> findByYear(@Param(value = "year") String year);
	
	@Query("select c from Car c where price between :start AND :end order by price")
	public List<Car> findByPriceRange(@Param(value = "start") double start,@Param(value = "end") double end);
	
	@Query("select c from Car c where model = :model AND color =:color")
	public List<Car> findByModelColor(@Param(value = "model")String model, @Param(value = "color")String color);
}
