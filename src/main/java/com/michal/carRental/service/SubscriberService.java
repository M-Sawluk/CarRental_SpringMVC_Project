package com.michal.carRental.service;

import com.michal.carRental.domain.Subscriber;

public interface SubscriberService {

	void addSubscriber(Subscriber subscriber);
	
	void deleteSubscriber(Subscriber subscriber);
	
	void updateSubsriber(Subscriber subscriber);
	
	Subscriber findSubscriberByEmail(String email); 
	
	Subscriber getSubscriber(long id);
	
}
