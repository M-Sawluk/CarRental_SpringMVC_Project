package com.michal.carRental.service;

import com.michal.carRental.domain.Subscriber;
import com.michal.carRental.exception.ConfirmationFailedException;

public interface MailingListService {

	Subscriber getSubscriber(long id);
	
	void addSubscriber(Subscriber subscriber);
	
	void confirmSubscriber(long subscriberId, String digest) throws ConfirmationFailedException;
	
}
