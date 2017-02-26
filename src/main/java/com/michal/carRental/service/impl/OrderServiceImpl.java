package com.michal.carRental.service.impl;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michal.carRental.domain.Order;
import com.michal.carRental.domain.OrderStatus;
import com.michal.carRental.domain.User;
import com.michal.carRental.domain.repository.OrderRepository;
import com.michal.carRental.exception.InvalidCarException;
import com.michal.carRental.exception.InvalidDateException;
import com.michal.carRental.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	

	
	public Order validOrder(Order order)
	{
		if (order.getRentEnd().before(order.getRentStart())) 
			{
				throw new InvalidDateException();
			}
	
		order.setStatus(OrderStatus.ACTIVE);
		order.setPrice((int)((order.getRentEnd().getTime()-order.getRentStart().getTime())/(1000*60*60*24))*order.getCar().getPrice());
		if(checkAvailability(order.getCar().getId(),order.getRentingPlace().getId(), order.getRentStart(), order.getRentEnd())==false)
		{
			throw new InvalidCarException();
		}

		
		return order;
	}

	@Override
	public boolean checkAvailability(long carId,long placeId, Date start, Date end) {
		
		return orderRepository.checkAvailability(carId, placeId, start, end);
		
	}
	
	public void saveOrder(Order order)
	{
		orderRepository.saveOrder(order);
	}
	
	public List<Order> getPastOrders(User user)
	{
		return orderRepository.getPastOrders(user);
	}
	
	public List<Order> getPresentOrders(User user)
	{
		return orderRepository.getPresentOrders(user);
	}
	
	public List<Order> getAllOrders()
	{
		return orderRepository.getAllOrders();
	}
	
	public void deleteOrder(long id)
	{
		orderRepository.deleteOrder(id);
	}
	public Order findOrderById(long id)
	{
		return orderRepository.findOrderById(id);
	}
	
	public void updateOrder(Order order)
	{
		orderRepository.updateOrder(order);
		
	}

}
