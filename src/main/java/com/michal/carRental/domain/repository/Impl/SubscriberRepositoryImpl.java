package com.michal.carRental.domain.repository.Impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.michal.carRental.domain.Subscriber;
import com.michal.carRental.domain.repository.SubscriberRepository;

@Repository
public  class SubscriberRepositoryImpl implements SubscriberRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addSubscriber(Subscriber subscriber) {
		
		sessionFactory.getCurrentSession().save(subscriber);
	}

	@Override
	@Transactional
	public void deleteSubscriber(Subscriber subscriber) {
		
		sessionFactory.getCurrentSession().delete(subscriber);
		
	}

	@Override
	@Transactional
	public Subscriber findSubscriberByEmail(String email) {
		
		return (Subscriber) sessionFactory.getCurrentSession().createQuery("select from Subscriber where email=:e").setParameter("e", email).uniqueResult();
	}

	@Override
	@Transactional
	public Subscriber getSubscriber(long id) {
		
		return (Subscriber) sessionFactory.getCurrentSession().get(Subscriber.class, id);
	}

	@Override
	@Transactional
	public void updateSubscriber(Subscriber subscriber) {
		
		sessionFactory.getCurrentSession().update(subscriber);
	}

}
