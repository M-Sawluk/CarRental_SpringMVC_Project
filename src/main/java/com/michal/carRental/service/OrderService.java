package com.michal.carRental.service;

import java.util.List;

import com.michal.carRental.domain.Order;
import com.michal.carRental.domain.User;

public interface OrderService {
	
	void saveOrder(Order order);
	
	List<Order> getPastOrders(User user);
	
	List<Order> getPresentOrders(User user);
	
	List<Order> getAllOrders();
	
	void deleteOrder(long id);
	
	Order findOrderById(long id);
	
	void updateOrder(Order order);
}
