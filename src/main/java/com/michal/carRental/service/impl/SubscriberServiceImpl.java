package com.michal.carRental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michal.carRental.domain.Subscriber;
import com.michal.carRental.domain.repository.SubscriberRepository;
import com.michal.carRental.service.SubscriberService;

@Service
public class SubscriberServiceImpl implements SubscriberService {

	private SubscriberRepository subscriberRepository;

	@Autowired
	public SubscriberServiceImpl(SubscriberRepository subscriberRepository) {
		this.subscriberRepository = subscriberRepository;
	}

	@Override
	public void addSubscriber(Subscriber subscriber) {

		subscriberRepository.addSubscriber(subscriber);
	}

	@Override
	public void deleteSubscriber(Subscriber subscriber) {

		subscriberRepository.deleteSubscriber(subscriber);

	}

	@Override
	public Subscriber findSubscriberByEmail(String email) {

		return subscriberRepository.findSubscriberByEmail(email);
	}

	@Override
	public Subscriber getSubscriber(long id) {

		return subscriberRepository.getSubscriber(id);
	}

	@Override
	public void updateSubsriber(Subscriber subscriber) {

		subscriberRepository.updateSubscriber(subscriber);
	}

}
