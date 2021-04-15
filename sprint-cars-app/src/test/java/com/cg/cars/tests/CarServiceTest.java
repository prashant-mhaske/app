package com.cg.cars.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.cars.exceptions.CarNotFoundException;
import com.cg.cars.models.Car;
import com.cg.cars.repositories.ICarRepository;
import com.cg.cars.services.ICarServiceImpl;

@SpringBootTest
public class CarServiceTest {

	@Autowired
	ICarServiceImpl carService;

	@MockBean
	private ICarRepository carRepository;

	Car car5 = new Car(103, "Ford", "Eco", "Orange", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");

	@Test
	public void testGetCarException() throws CarNotFoundException {
		int id = 5005;
		assertThrows(CarNotFoundException.class, () -> carService.getCarById(id));
		System.out.println("Car Id cannot be retervied");

	}

	@Test
	public void getAllCarsTest() {
		when(carRepository.findAll()).thenReturn(Stream
				.of(new Car(103, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra"),
						new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2016, 03, 15), "Maharashtra"))
				.collect(Collectors.toList()));
		assertEquals(2, carService.getAllCars().size());
		verify(carRepository, times(1)).findAll();
	}

	@Test
	public void getCarByIdTest() {
		Car c = new Car(101, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		when(carRepository.findById(c.getId())).thenReturn(Optional.of(c));
		assertEquals(c, carService.getCarById(c.getId()));
		verify(carRepository, times(1)).findById(c.getId());
	}

	@Test
	public void getCarsByLocationTest() {
		String location = "Maharashtra";

		Car car1 = new Car(103, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		when(carRepository.findByRegistrationState(location))
				.thenReturn(Stream.of(car1, car2).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByLocation(location));
		verify(carRepository, times(1)).findByRegistrationState(location);

	}

	@Test
	public void getCarsByYearTest() {
		Car car1 = new Car(103, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2020, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		when(carRepository.findByYear("2020")).thenReturn(Stream.of(car1, car2).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByYear("2020"));
		verify(carRepository, times(1)).findByYear("2020");
	}

	@Test
	public void getCarsByBrandTest() {
		Car car1 = new Car(103, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		when(carRepository.findByBrand("Ford")).thenReturn(Stream.of(car1, car2).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByBrand("Ford"));
		verify(carRepository, times(1)).findByBrand("Ford");
	}

	@Test
	public void getCarsByModelTest() {
		Car car1 = new Car(103, "Ford", "Eco", "Orange", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		when(carRepository.findByModel("Eco")).thenReturn(Stream.of(car1, car2).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByModel("Eco"));
		verify(carRepository, times(1)).findByModel("Eco");
	}

	@Test
	public void getCarsByPriceTest() {
		Car car1 = new Car(103, "Ford", "Eco", "Orange", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 18.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		when(carRepository.findByPrice(18.5)).thenReturn(Stream.of(car1, car2).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByPrice(18.5));
		verify(carRepository, times(1)).findByPrice(18.5);
	}

	@Test
	public void getCarsByPriceRangeTest() {
		Car car1 = new Car(103, "Ford", "Eco", "Orange", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 8.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		when(carRepository.findByPriceRange(10, 19)).thenReturn(Stream.of(car1, car2).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByPriceRange(10, 19));
		verify(carRepository, times(1)).findByPriceRange(10, 19);
	}

	@Test
	public void getCarsByModelColorTest() {
		Car car1 = new Car(103, "Honda", "city", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Honda", "city", "Black", "Vxi", 8.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		when(carRepository.findByModelColor("Eco", "Black"))
				.thenReturn(Stream.of(car1, car2).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByModelColor("Eco", "Black"));
		verify(carRepository, times(1)).findByModelColor("Eco", "Black");
	}

	@Test
	public void updateCarTest() {
		when(carRepository.save(car5)).thenReturn(car5);
		assertEquals(car5, carService.update(car5.getId(), car5));
		verify(carRepository, times(1)).save(car5);
	}

	@Test
	public void deleteTest() {
		Car car6 = new Car(103, "Ford", "Eco", "Orange", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		when(carRepository.findById(car6.getId())).thenReturn(Optional.of(car6));
		assertEquals(car6, carService.delete(car6.getId()));
		verify(carRepository, times(1)).deleteById(car6.getId());

	}
}
