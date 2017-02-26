package com.michal.carRental.domain.repository.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.michal.carRental.domain.Role;
import com.michal.carRental.domain.User;
import com.michal.carRental.domain.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory session;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	

	@Transactional
	public void createUser(User user) {
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(getRole("ROLE_USER"));

		user.setRoles(roles);
		String bCrypPassword = bcryptEncoder.encode(user.getPassword());
		
		user.setPassword(bCrypPassword);
		user.setPassword1(bCrypPassword);

		session.getCurrentSession().save(user);
	}
	
	@Transactional
	public User getUserByUserName(String userName)
	{
		Criteria criteria = session.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", userName));
		return (User) criteria.uniqueResult();
		
	}


	@Transactional
	public void updateUser(User user)
	{
		user.setPassword1(user.getPassword());
		session.getCurrentSession().update(user);
	}
	
	@Transactional
	public List<User> getUserList()
	{
		return (List<User>)session.getCurrentSession().createQuery("from User").list();
		
	}
	
	@Transactional
	public void deleteUser(String name)
	{
		session.getCurrentSession().delete(getUserByUserName(name));
		
	}
	
	
	
	@Transactional
	public void changeUserRole(User user,String role)
	{
		
		user.getRoles().add(getRole(role));
		
		updateUser(user);
	}
	
	//Helper
	@Transactional
	public Role getRole(String name)
	{
		Criteria crit = session.getCurrentSession().createCriteria(Role.class);
		crit.add(Restrictions.eq("roleName", name));
		
		return (Role) crit.uniqueResult();
	}
	
	@Transactional
	public User getUser(long id)
	{
		return (User) session.getCurrentSession().get(User.class, id);
	}
	
	@Transactional
	public void upadateUserWithChangedPass(User user)
	{
		String bCrypPassword = bcryptEncoder.encode(user.getPassword());
		user.setPassword(bCrypPassword);
		user.setPassword1(bCrypPassword);
		
		session.getCurrentSession().update(user);
		
	}
}
