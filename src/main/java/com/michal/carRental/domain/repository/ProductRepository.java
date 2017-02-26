package com.michal.carRental.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.michal.carRental.domain.Car;
import com.michal.carRental.forms.CarStorageForm;

public interface ProductRepository {

	void addCar(Car car);
	
	Car findCarByCarId(String carId);
	
	List<Car> getCarForCarousel();
	
	List<Car> getAllCars();
	
	Set<Car> findCarByName(String name);
	
	Set<Car> getProductsByFilter(Map<String,List<String>> filterParams , String name);
	
	void deleteCar(String carId);
	
	void updateCar(Car newCar);
	
	void setCarUnits(CarStorageForm cSF);
	
	
}
