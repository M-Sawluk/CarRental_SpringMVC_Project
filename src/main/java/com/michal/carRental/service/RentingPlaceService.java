package com.michal.carRental.service;

import java.util.List;

import com.michal.carRental.domain.RentingPlace;

public interface RentingPlaceService {

	
	void addPlace(RentingPlace place);
	
	List<RentingPlace> getPlaceList();
	
	RentingPlace getRentingPlaceById(long id);
}
