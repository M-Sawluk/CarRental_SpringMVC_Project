package com.michal.carRental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michal.carRental.domain.Order;
import com.michal.carRental.domain.OrderStatus;
import com.michal.carRental.domain.User;
import com.michal.carRental.domain.repository.OrderRepository;
import com.michal.carRental.exception.InvalidCarException;
import com.michal.carRental.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Order validOrder(Order order) {

		if (orderRepository.getOrdersInSpecificPeriodOfTimeWithCarIdAndPlaceId(order.getCar().getId(),
				order.getRentingPlace().getId(), order.getRentStart(), order.getRentEnd()) >= orderRepository
						.getUnitsOfCarInSpecificPlace(order.getCar().getId(), order.getRentingPlace().getId())) {
			throw new InvalidCarException();
		}

		order.setStatus(OrderStatus.ACTIVE);

		return order;
	}

	public void saveOrder(Order order) {
		orderRepository.saveOrder(order);
	}

	public List<Order> getPastOrders(User user) {
		return orderRepository.getPastOrders(user);
	}

	public List<Order> getPresentOrders(User user) {
		return orderRepository.getPresentOrders(user);
	}

	public List<Order> getAllOrders() {
		return orderRepository.getAllOrders();
	}

	public void deleteOrder(long id) {
		orderRepository.deleteOrder(id);
	}

	public Order findOrderById(long id) {
		return orderRepository.findOrderById(id);
	}

	public void updateOrder(Order order) {
		orderRepository.updateOrder(order);

	}

}
