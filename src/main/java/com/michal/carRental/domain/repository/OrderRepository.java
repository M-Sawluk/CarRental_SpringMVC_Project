package com.michal.carRental.domain.repository;

import java.util.Date;
import java.util.List;


import com.michal.carRental.domain.Order;
import com.michal.carRental.domain.User;

public interface OrderRepository {
	
	void saveOrder(Order order);
	
	List<Order> getPastOrders(User user);
	
	List<Order> getPresentOrders(User user);
	
	List<Order> getAllOrders();
	
	void deleteOrder(long id);
	
	Order findOrderById(long id);
	
	void updateOrder(Order order);
	
	Integer getOrdersInSpecificPeriodOfTimeWithCarIdAndPlaceId(long carId, long placeId, Date start, Date end);
	
	Integer getUnitsOfCarInSpecificPlace(long carId, long placeId);
}
