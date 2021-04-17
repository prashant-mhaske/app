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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.cars.exceptions.CarNotFoundException;
import com.cg.cars.models.Car;
import com.cg.cars.repositories.ICarRepository;
import com.cg.cars.services.ICarServiceImpl;

/**
 *
 * @author TEAM 2 MEMBERS: Abhishek Sen Prashant Mhaske Rishabh Gupta Akshay
 *         Talekar Nikhil Nichit
 *
 */

@SpringBootTest
class CarServiceTest {

	@Autowired
	ICarServiceImpl carService;

	@MockBean
	private ICarRepository carRepository;

	Car car5;
	Car car;
	List<Car> c = new ArrayList<>();

	@BeforeEach
	void init() {

		car5 = new Car(103, "Ford", "Eco", "Orange", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");

		car = new Car();
		car.setId(101);
		car.setBrand("Kia");
		car.setModel("Seltos");
		car.setColor("White");
		car.setVariant("old");
		car.setPrice(9.5);
		car.setRegistrationYear(LocalDate.of(2021, 04, 03));
		car.setRegistrationState("Maharashtra");

	}

	@Test
	@DisplayName("Test to check whether car is added")
	void addCarTest() {
		Mockito.when(carRepository.save(car5)).thenReturn(car5);
		assertEquals(car5, carService.addCar(car5));
	}

	@Test
	@DisplayName("Test to check non-existing car Id")
	void getCarExceptionTest() throws CarNotFoundException {
		int id = 5005;
		assertThrows(CarNotFoundException.class, () -> carService.getCarById(id));

	}

	@Test
	@DisplayName("Test to check whether all records get")
	void getAllCarsTest() {
		when(carRepository.findAll()).thenReturn(Stream
				.of(new Car(103, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra"),
						new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2016, 03, 15), "Maharashtra"),
						car)
				.collect(Collectors.toList()));
		assertEquals(3, carService.getAllCars().size());
		verify(carRepository, times(1)).findAll();
	}

	@Test
	@DisplayName("Test to check whether car is present for given Id")
	void getCarByIdTest() {
		Car c = new Car(101, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		when(carRepository.findById(c.getId())).thenReturn(Optional.of(c));
		assertEquals(c, carService.getCarById(c.getId()));
		verify(carRepository, times(1)).findById(c.getId());
	}

	@Test
	@DisplayName("Test to check whether car is available for given location")
	void getCarsByLocationTest() {
		String location = "Maharashtra";

		Car car1 = new Car(103, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car);
		when(carRepository.findByRegistrationState(location))
				.thenReturn(Stream.of(car1, car2, car).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByLocation(location));
		verify(carRepository, times(1)).findByRegistrationState(location);

	}

	@Test
	@DisplayName("Test to check whether cars are not available for given location")
	void getCarsByLocationNegativeTest() {
		String location = "Maharashtra";

		when(carRepository.findByRegistrationState(location)).thenReturn(c);
		assertThrows(CarNotFoundException.class, () -> carService.getCarsByLocation(location));
		verify(carRepository, times(1)).findByRegistrationState(location);

	}

	@Test
	@DisplayName("Test to check whether cars are available on year wise")
	void getCarsByYearTest() {

		Car car1 = new Car(103, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2020, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car);
		when(carRepository.findByYear("2020")).thenReturn(Stream.of(car1, car2, car).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByYear("2020"));
		verify(carRepository, times(1)).findByYear("2020");
	}

	@Test
	@DisplayName("Test to check whether cars are not available for given year")
	void getCarsByYearNegativeTest() {
		when(carRepository.findByYear("2020")).thenReturn(c);
		assertThrows(CarNotFoundException.class, () -> carService.getCarsByYear("2020"));
		verify(carRepository, times(1)).findByYear("2020");

	}

	@Test
	@DisplayName("Test to check whether car are available by brand")
	void getCarsByBrandTest() {
		Car car1 = new Car(103, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car);
		when(carRepository.findByBrand("Ford")).thenReturn(Stream.of(car1, car2, car).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByBrand("Ford"));
		verify(carRepository, times(1)).findByBrand("Ford");
	}

	@Test
	@DisplayName("Test to check whether car are not available by brand")
	void getCarsByBrandNegativeTest() {
		when(carRepository.findByBrand("Tata")).thenReturn(c);
		assertThrows(CarNotFoundException.class, () -> carService.getCarsByBrand("Tata"));
		verify(carRepository, times(1)).findByBrand("Tata");

	}

	@Test
	@DisplayName("Test to check whether car models are available")
	void getCarsByModelTest() {

		Car car1 = new Car(103, "Ford", "Eco", "Orange", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car);
		when(carRepository.findByModel("Eco")).thenReturn(Stream.of(car1, car2, car).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByModel("Eco"));
		verify(carRepository, times(1)).findByModel("Eco");
	}

	@Test
	@DisplayName("Test to check whether car models are not available")
	void getCarsByModelNegativeTest() {

		when(carRepository.findByModel("Eco")).thenReturn(c);
		assertThrows(CarNotFoundException.class, () -> carService.getCarsByModel("Eco"));
		verify(carRepository, times(1)).findByModel("Eco");

	}

	@Test
	@DisplayName("Test to check whether cars are available for given price")
	void getCarsByPriceTest() {

		Car car1 = new Car(103, "Ford", "Eco", "Orange", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 18.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car);
		when(carRepository.findByPrice(18.5)).thenReturn(Stream.of(car1, car2, car).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByPrice(18.5));
		verify(carRepository, times(1)).findByPrice(18.5);
	}

	@Test
	@DisplayName("Test to check whether cars are not available for given price")
	void getCarsByPriceNegativeTest() {
		when(carRepository.findByPrice(18.5)).thenReturn(c);
		assertThrows(CarNotFoundException.class, () -> carService.getCarsByPrice(18.5));
		verify(carRepository, times(1)).findByPrice(18.5);

	}

	@Test
	@DisplayName("Test to check whether cars are available by price range")
	void getCarsByPriceRangeTest() {

		Car car1 = new Car(103, "Ford", "Eco", "Orange", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 8.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car);
		when(carRepository.findByPriceRange(10, 19))
				.thenReturn(Stream.of(car1, car2, car).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByPriceRange(10, 19));
		verify(carRepository, times(1)).findByPriceRange(10, 19);
	}

	@Test
	@DisplayName("Test to check whether cars are not available by price range")
	void getCarsByPriceRangeNegativeTest() {
		when(carRepository.findByPriceRange(10.5, 18)).thenReturn(c);
		assertThrows(CarNotFoundException.class, () -> carService.getCarsByPriceRange(10.5, 18));
		verify(carRepository, times(1)).findByPriceRange(10.5, 18);

	}

	@Test
	@DisplayName("Test to check whether car models are available with color")
	void getCarsByModelColorTest() {

		Car car1 = new Car(103, "Honda", "city", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Honda", "city", "Black", "Vxi", 8.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car);
		when(carRepository.findByModelColor("Eco", "Black"))
				.thenReturn(Stream.of(car1, car2, car).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByModelColor("Eco", "Black"));
		verify(carRepository, times(1)).findByModelColor("Eco", "Black");
	}

	@Test
	@DisplayName("Test to check whether car models with color are not available")
	void getCarsByModelColorNegativeTest() {

		when(carRepository.findByModelColor("Eco", "Red")).thenReturn(c);
		assertThrows(CarNotFoundException.class, () -> carService.getCarsByModelColor("Eco", "Red"));
		verify(carRepository, times(1)).findByModelColor("Eco", "Red");

	}

	@Test
	@DisplayName("Test to check car is updated")
	void updateCarTest() {

		when(carRepository.save(car5)).thenReturn(car5);
		assertEquals(car5, carService.update(car5.getId(), car5));
		verify(carRepository, times(1)).save(car5);
	}

	@Test
	@DisplayName("Test to check car is deleted")
	void deleteTest() {

		Car car6 = new Car(103, "Ford", "Eco", "Orange", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		when(carRepository.findById(car6.getId())).thenReturn(Optional.of(car6));
		assertEquals(car6, carService.delete(car6.getId()));
		verify(carRepository, times(1)).deleteById(car6.getId());

	}

}
