package com.michal.carRental.domain.repository;

import com.michal.carRental.domain.Subscriber;

public interface SubscriberRepository {

	void addSubscriber(Subscriber subscriber);
	
	void deleteSubscriber(Subscriber subscriber);
	
	void updateSubscriber(Subscriber subscriber);
	
	Subscriber findSubscriberByEmail(String email); 
	
	Subscriber getSubscriber(long id);
}
