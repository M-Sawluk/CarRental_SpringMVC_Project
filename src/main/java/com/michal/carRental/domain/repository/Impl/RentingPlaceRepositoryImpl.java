package com.michal.carRental.domain.repository.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.michal.carRental.domain.RentingPlace;
import com.michal.carRental.domain.repository.RentingPlaceRepository;

@Repository
public class RentingPlaceRepositoryImpl implements RentingPlaceRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public RentingPlaceRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addPlace(RentingPlace place) {
		sessionFactory.getCurrentSession().save(place);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<RentingPlace> getPlaceList() {
		return (List<RentingPlace>) sessionFactory.getCurrentSession().createQuery("from RentingPlace").list();
	}

	@Transactional
	public RentingPlace getRentingPlaceById(long id) {
		return (RentingPlace) sessionFactory.getCurrentSession().get(RentingPlace.class, id);

	}

}
