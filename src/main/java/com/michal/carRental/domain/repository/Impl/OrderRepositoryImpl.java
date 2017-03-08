package com.michal.carRental.domain.repository.Impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.michal.carRental.domain.CarStorage;
import com.michal.carRental.domain.Order;
import com.michal.carRental.domain.User;
import com.michal.carRental.domain.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public OrderRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrder(Order order) {
		sessionFactory.getCurrentSession().save(order);

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Order> getPastOrders(User user) {
		Date presentDate = new Date();

		return sessionFactory.getCurrentSession()
				.createQuery("select o from Order o left join fetch o.user as user where "
						+ "(user.id=:id and rentEnd<:date) order by rentEnd")
				.setParameter("id", user.getId()).setParameter("date", presentDate).list();

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Order> getPresentOrders(User user) {
		Date presentDate = new Date();

		return sessionFactory.getCurrentSession()
				.createQuery("select o from Order o left join fetch o.user as user "
						+ "where (user.id=:id and rentEnd>:date ) order by rentEnd")
				.setParameter("id", user.getId()).setParameter("date", presentDate).list();

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Order> getAllOrders() {
		return sessionFactory.getCurrentSession().createQuery("from Order order by status , rentStart").list();

	}

	@Transactional
	public void deleteOrder(long id) {
		sessionFactory.getCurrentSession().delete(findOrderById(id));

	}

	@Transactional
	public Order findOrderById(long id) {

		return (Order) sessionFactory.getCurrentSession()
				.createQuery(
						"select o from Order o left join fetch o.user as user left join fetch o.car as car left join fetch o.rentingPlace as rentingPlace "
								+ "where ORDER_ID=:id")
				.setParameter("id", id).uniqueResult();
	}

	@Transactional
	public void updateOrder(Order order) {
		sessionFactory.getCurrentSession().update(order);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Integer getOrdersInSpecificPeriodOfTimeWithCarIdAndPlaceId(long carId, long placeId, Date start, Date end) {

		List<Order> orders = sessionFactory.getCurrentSession()
				.createQuery(
						"select o from Order o left join fetch o.car as car left join fetch o.user as user left join fetch o.rentingPlace as rentingPlace where "
								+ "car.id=:id and rentingPlace.id=:pId and ((rentStart>=:start and rentStart<=:end) or (rentEnd>=:start and rentEnd<=:end) or (rentStart<=:start and rentEnd>=:end))")
				.setParameter("id", carId).setParameter("start", start).setParameter("end", end)
				.setParameter("pId", placeId).list();

		return orders.size();
	}

	@Transactional
	public Integer getUnitsOfCarInSpecificPlace(long carId, long placeId) {
		CarStorage cStor = (CarStorage) sessionFactory.getCurrentSession()
				.createQuery(
						"select cs from CarStorage cs left join fetch cs.car as car left join fetch cs.rentingPlace as rentingPlace"
								+ " where car.id = :id and rentingPlace.id=:pId")
				.setParameter("id", carId).setParameter("pId", placeId).uniqueResult();

		return cStor.getUnits();
	}

}
