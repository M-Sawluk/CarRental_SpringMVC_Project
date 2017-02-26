package com.michal.carRental.domain.repository;

import java.util.List;

import com.michal.carRental.domain.RentingPlace;

public interface RentingPlaceRepository {

	void addPlace(RentingPlace place);
	
	List<RentingPlace> getPlaceList();
	
	RentingPlace getRentingPlaceById(long id);
	

	
}
