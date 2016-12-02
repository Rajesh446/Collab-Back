package com.niit.collab.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Forum;

@Repository

public class ForumDAOImpl implements ForumDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}

	@Transactional
	public boolean save(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
	
		
		
	}

	@Transactional
	public boolean update(Forum forum) {
		
		try
		{
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	
	}

	@Transactional
	public boolean delete(Forum forum)
	{
		
		try
		{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<Forum> list() {
		 @SuppressWarnings("deprecation")
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Forum.class);
		@SuppressWarnings("unchecked")
		List<Forum> list=c.list();
		return list;
	}

	@Transactional
	public Forum getforum(int id) {
		String hql = "from forum where id="+"'"+ id +"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum>list=((Criteria) query).list(); 
		if(list==null)
		{
			return null;
			
		}
		else
		{
			return list.get(0);
		}
	}

}
