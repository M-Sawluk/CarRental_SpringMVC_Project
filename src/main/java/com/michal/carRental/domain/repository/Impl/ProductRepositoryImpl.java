package com.michal.carRental.domain.repository.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.michal.carRental.domain.Car;
import com.michal.carRental.domain.CarStorage;
import com.michal.carRental.domain.User;
import com.michal.carRental.domain.repository.ProductRepository;
import com.michal.carRental.forms.CarStorageForm;
import com.michal.carRental.service.RentingPlaceService;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

	@Autowired
	private SessionFactory  sessionFactory;
	
	@Transactional
	@Override
	public void addCar(Car car) {
		
		sessionFactory.getCurrentSession().save(car);
		
	}
	
	@Transactional
	public Car findCarByCarId(String carId)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Car.class);
		criteria.add(Restrictions.eq("carId", carId));
	
		return (Car) criteria.uniqueResult();
	}
	
	@Transactional
	public List<Car> getCarForCarousel() {
		
		List<Car> listDataBase =new ArrayList<Car>();
		
		listDataBase = sessionFactory.getCurrentSession().createQuery("from Car").list();

		List<Car> list = new ArrayList<Car>();
		
		
		for(int i=0;i<4;i++)
		{
			int k=(int)Math.round(Math.random()*(listDataBase.size()-1));
			list.add(listDataBase.get(k));
			listDataBase.remove(k);
		}
		
		while(list.size()<4)
		{
			list.add(new Car());
		}
		
		
		return list;
	}
	
	@Transactional
	public List<Car> getAllCars()
	{
		List<Car> list = new ArrayList<Car>();
		
		list = sessionFactory.getCurrentSession().createQuery("from Car").list();
		
		return list;
	}
	
	@Transactional
	public Set<Car> findCarByName(String name)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Car.class);
		criteria.add(Restrictions.eq("name", name));
		Criteria criteria1 = sessionFactory.getCurrentSession().createCriteria(Car.class);
		criteria1.add(Restrictions.eq("manufacturer", name));
		
		Set<Car> crit1 = new HashSet<Car>();
		

		crit1.addAll(criteria.list());
		crit1.addAll(criteria1.list());
		
		return crit1;
	}
	
	@Transactional
	public Set<Car> getProductsByFilter(Map<String,List<String>> filterParams, String name)
	{
		Set<Car> finallList = new HashSet<Car>();
		
		Set<String> criterias = filterParams.keySet();
		
		Criteria criteria= sessionFactory.getCurrentSession().createCriteria(Car.class);
		
		if(criterias.contains("low") && !filterParams.get("low").get(0).equals("0"))
		{
		
			criteria.add(Restrictions.ge("price", Integer.parseInt(filterParams.get("low").get(0))));
		}
		if(criterias.contains("high") && !filterParams.get("high").get(0).equals("0"))
		{
	
			criteria.add(Restrictions.le("price", Integer.parseInt(filterParams.get("high").get(0))));
		}
		
		
		
		finallList.addAll(criteria.list());
		
		if(!name.equals(""))
		{
		finallList.retainAll(findCarByName(name));
		}
		
		
		return finallList;
	}
	
	@Transactional
	public void deleteCar(String carId)
	{
		sessionFactory.getCurrentSession().delete(findCarByCarId(carId));
	}
	
	@Transactional
	public void updateCar(Car newCar)
	{
		sessionFactory.getCurrentSession().update(newCar);
	}
	
	@Transactional
	public void setCarUnits(CarStorageForm cSF)
	{
		
		
		for(int i=0;i<cSF.getStorages().size();i++)
			{
			
					CarStorage cs = (CarStorage) sessionFactory.getCurrentSession().createQuery("select cs from CarStorage cs left join fetch cs.car as car left join fetch cs.rentingPlace as rentingPlace"
							+ " where car.id = :id and rentingPlace.id=:pId " ).setParameter("id", cSF.getStorages().get(i).getCar().getId()).setParameter("pId",cSF.getStorages().get(i).getRentingPlace().getId()).uniqueResult();
					
					if(cs!=null)
					{
						cs.setUnits(cs.getUnits()+cSF.getStorages().get(i).getUnits());
						sessionFactory.getCurrentSession().update(cs);
					
					}
					else
					{
	
						sessionFactory.getCurrentSession().save(cSF.getStorages().get(i));
					}
				
			}
					
	}
	

}
