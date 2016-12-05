package com.niit.collab.DAO;

import java.beans.Transient;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.niit.collab.model.Friend;

@Repository
public class FriendDAOImpl implements FriendDAO

{
	
	public static final Logger log=LoggerFactory.getLogger(FriendDAOImpl.class);

	@Autowired
	
	private FriendDAO friendDAO;
	 
	@Autowired
	private SessionFactory sessionFactory;
	
	public FriendDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	
	
	@Transactional
	
	public boolean saveOrUpdate(Friend friend) 
	{
	try
	{
		sessionFactory.getCurrentSession().saveOrUpdate(friend);
		return true;
		
	}
	
	catch(Exception e)
	
	{
		e.printStackTrace();
	}
		return false;
	}

	/*@Transactional
	public boolean Update(Friend friend)
	{
	try
	{
		SessionFactory.getCurrentSession().update(friend);
		
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return false;
	}*/

	@Transactional
	public Friend getFriend(int id)
	
	{
		String hql = "from friend where id="+"'"+id+"'";
		@SuppressWarnings({ "unused", "rawtypes" })
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend>list=query.list();
		
		if (list==null)
				{
			return null;
				}
		else
		{
		
			return list.get(0);
			
		}
	
	}

	@Transactional
	public Friend newrequest(int id)
	
	{
	String hql="from friend where userid="+"'"+id+"'"+" and status='n'";
	log.debug(hql);
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Friend>list=query.list();
	if(list==null)
	{
		return null;
		
	}
	else
		{
		
		return list.get(0);
		}
	}

	@Transactional
	public List<Friend> list() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Friend.class);
		@SuppressWarnings("unchecked")
		List<Friend>list=c.list();
		return list;
	}




	@Transactional
	public boolean Delete(Friend friend) {
		try
		{
			sessionFactory.getCurrentSession().delete(friend);
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}




	


	@Transactional
	public List<Friend> getfriendlist(int uid) {
		String hql="from Friend where userid= "+uid;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list = query.list();
		return list;
	}





}
