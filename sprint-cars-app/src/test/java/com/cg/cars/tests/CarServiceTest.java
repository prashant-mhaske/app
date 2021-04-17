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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.cars.exceptions.CarNotFoundException;
import com.cg.cars.models.Car;
import com.cg.cars.repositories.ICarRepository;
import com.cg.cars.services.ICarServiceImpl;

@SpringBootTest
class CarServiceTest {

	@Autowired
	ICarServiceImpl carService;

	@MockBean
	private ICarRepository carRepository;

	Car car5;
	Car car; 
	@BeforeEach
	void init()
	{
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
	 void getCarExceptionTest() throws CarNotFoundException {
		int id = 5005;
		assertThrows(CarNotFoundException.class, () -> carService.getCarById(id));
	}

	@Test
	void addCarTest()
	{
		Mockito.when(carRepository.save(car5)).thenReturn(car5);
		assertEquals(car5, carService.addCar(car5));
	}
	
	@Test
	 void getAllCarsTest() {
		when(carRepository.findAll()).thenReturn(Stream
				.of(new Car(103, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra"),
						new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2016, 03, 15), "Maharashtra"),car)
				.collect(Collectors.toList()));
		assertEquals(3, carService.getAllCars().size());
		verify(carRepository, times(1)).findAll();
	}

	@Test
	 void getCarByIdTest() {
		Car c = new Car(101, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		when(carRepository.findById(c.getId())).thenReturn(Optional.of(c));
		assertEquals(c, carService.getCarById(c.getId()));
		verify(carRepository, times(1)).findById(c.getId());
	}

	@Test
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
	
	//Negative *********************
	@Test
	 void getCarsByLocationNegativeTest() {
		String location = "Maharashtra";

		when(carRepository.findByRegistrationState(location)).thenReturn(null);
		assertThrows(CarNotFoundException.class ,()-> carService.getCarsByLocation(location));
		verify(carRepository, times(1)).findByRegistrationState(location);

	}

	@Test
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

	//Negative *********************
		@Test
		 void getCarsByYearNegativeTest() {
			when(carRepository.findByYear("2020")).thenReturn(null);
			assertThrows(CarNotFoundException.class ,()-> carService.getCarsByYear("2020"));
			verify(carRepository, times(1)).findByYear("2020");

		}
	
	@Test
	 void getCarsByBrandTest() {
		Car car1 = new Car(103, "Ford", "Safari", "Black", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 15.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car);
		when(carRepository.findByBrand("Ford")).thenReturn(Stream.of(car1, car2,car).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByBrand("Ford"));
		verify(carRepository, times(1)).findByBrand("Ford");
	}

	//Negative *********************
		@Test
		 void getCarsByBrandNegativeTest() {
			when(carRepository.findByBrand("Tata")).thenReturn(null);
			assertThrows(CarNotFoundException.class ,()-> carService.getCarsByBrand("Tata"));
			verify(carRepository, times(1)).findByBrand("Tata");

		}
	
	@Test
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
		
	//Negative *********************
		@Test
		 void getCarsByModelNegativeTest() {

			when(carRepository.findByModel("Eco")).thenReturn(null);
			assertThrows(CarNotFoundException.class ,()-> carService.getCarsByModel("Eco"));
			verify(carRepository, times(1)).findByModel("Eco");

		}
	
	@Test
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
	
	
	  //Negative *********************
	  
		@Test
		void getCarsByPriceNegativeTest() {
			when(carRepository.findByPrice(18.5)).thenReturn(null);
			assertThrows(CarNotFoundException.class, () -> carService.getCarsByPrice(18.5));
			 verify(carRepository, times(1)).findByPrice(18.5);

		}
	 
	@Test
	 void getCarsByPriceRangeTest() {
		Car car1 = new Car(103, "Ford", "Eco", "Orange", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		Car car2 = new Car(104, "Ford", "Eco", "Black", "Vxi", 8.5, LocalDate.of(2016, 03, 15), "Maharashtra");

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);
		cars.add(car);
		when(carRepository.findByPriceRange(10, 19)).thenReturn(Stream.of(car1, car2, car).collect(Collectors.toList()));
		assertEquals(cars, carService.getCarsByPriceRange(10, 19));
		verify(carRepository, times(1)).findByPriceRange(10, 19);
	}
		
	//Negative *********************
		@Test
		 void getCarsByPriceRangeNegativeTest() {
			when(carRepository.findByPriceRange(10.5,18)).thenReturn(null);
			assertThrows(CarNotFoundException.class ,()-> carService.getCarsByPriceRange(10.5,18));
			verify(carRepository, times(1)).findByPriceRange(10.5,18);

		}
	
	@Test
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

	
	  //Negative *********************
		@Test
		void getCarsByModelColorNegativeTest() {

			when(carRepository.findByModelColor("Eco", "Red")).thenReturn(null);
			assertThrows(CarNotFoundException.class, () -> carService.getCarsByModelColor("Eco", "Red"));
			 verify(carRepository,times(1)).findByModelColor("Eco", "Red");

		}
	 
	
	@Test
	 void updateCarTest() {
		when(carRepository.save(car5)).thenReturn(car5);
		assertEquals(car5, carService.update(car5.getId(), car5));
		verify(carRepository, times(1)).save(car5);
	}

	@Test
	 void deleteTest() {
		Car car6 = new Car(103, "Ford", "Eco", "Orange", "Vxi", 18.5, LocalDate.of(2020, 01, 25), "Maharashtra");
		when(carRepository.findById(car6.getId())).thenReturn(Optional.of(car6));
		assertEquals(car6, carService.delete(car6.getId()));
		verify(carRepository, times(1)).deleteById(car6.getId());

	}
	
	
	
}
