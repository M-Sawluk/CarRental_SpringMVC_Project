package com.michal.carRental.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michal.carRental.domain.Car;
import com.michal.carRental.domain.Order;
import com.michal.carRental.domain.repository.ProductRepository;
import com.michal.carRental.forms.CarStorageForm;
import com.michal.carRental.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void add(Car car) {
		
		productRepository.addCar(car);
	}

	public Car findCarByCarId(String carId)
	{
		return productRepository.findCarByCarId(carId);
	}
	
	public List<Car> getCarForCarousel()
	{
		return productRepository.getCarForCarousel();
	}
	
	public List<Car> getAllCars()
	{
		
		return productRepository.getAllCars();
	}
	
	public Set<Car> findCarByName(String name)
	{
		return productRepository.findCarByName(name);
	}
	
	public Set<Car> getProductsByFilter(Map<String,List<String>> filterParams , String name)
	{
		return productRepository.getProductsByFilter(filterParams , name);
	}
	
	public void deleteCar(String carId)
	{
		productRepository.deleteCar(carId);
	}
	
	public void updateCar(Car newCar)
	{
		productRepository.updateCar(newCar);
	}
	
	public void setCarUnits(CarStorageForm cSF)
	{
		productRepository.setCarUnits(cSF);
	}
	
	public Car fillCar(Order order)
	{
		
		if(order.getSelectedCar()==null)
		{
		
			return order.getCar();
		}
		else
		{

			return findCarByCarId(order.getSelectedCar());
		}
	}
		
}
