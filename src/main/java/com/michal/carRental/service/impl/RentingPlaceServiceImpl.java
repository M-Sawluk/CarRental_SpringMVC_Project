package com.michal.carRental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michal.carRental.domain.RentingPlace;
import com.michal.carRental.domain.repository.RentingPlaceRepository;
import com.michal.carRental.exception.InvalidCityException;
import com.michal.carRental.service.RentingPlaceService;

@Service
public class RentingPlaceServiceImpl implements RentingPlaceService{

	private RentingPlaceRepository reningPlaceRepository;
	
	@Autowired
	public RentingPlaceServiceImpl(RentingPlaceRepository reningPlaceRepository) {
		this.reningPlaceRepository = reningPlaceRepository;
	}

	public void addPlace(RentingPlace place)
	{
		reningPlaceRepository.addPlace(place);
	}
	
	public List<RentingPlace> getPlaceList()
	{
		return reningPlaceRepository.getPlaceList();
	}
	
	public RentingPlace getRentingPlaceById(long id)
	{
		return reningPlaceRepository.getRentingPlaceById(id);
	}
	
	public RentingPlace validCity(long id)
	{
		
		RentingPlace rPlace = reningPlaceRepository.getRentingPlaceById(id);
				
		if(rPlace == null || rPlace.getCity().equals(""))
			{
				throw new InvalidCityException(id);
			}
			
			
		return rPlace;
	}
	
}
