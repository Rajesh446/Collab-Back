package com.niit.collab.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Event;


@Repository

public class EventDAOImpl implements EventDAO

{

	@Autowired
	
	SessionFactory sessionFactory;
	
	public EventDAOImpl(SessionFactory sessionFactory)
	
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean save(Event event) 
	
	{
		
	try
	
	{
		sessionFactory.getCurrentSession().save(event);
		System.out.println("Save");
		return true;
	}
	catch(Exception e)
	
	{
	
		e.printStackTrace();
		
		return false;
	}
	}

	@Transactional
	
	public boolean update(Event event) 
	
	{
		
		try
		{
			sessionFactory.getCurrentSession().update(event);
			System.out.println("Update");
			return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			
			return false;
		}
		
		
	}

	@Transactional
	public boolean delete(Event event) 
	
	{
	try
	{
		sessionFactory.getCurrentSession().delete(event);
		System.out.println("Delete");
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	
	}

}
