package com.niit.collab.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Blog;
import com.niit.collab.model.BlogLikes;



@Repository

public class BlogDAOImpl implements BlogDAO
{
	
	public static final Logger log=LoggerFactory.getLogger(BlogDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean Save(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			System.out.println("save");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


@Transactional
public boolean update(Blog blog) {
	
	
	try {
		 sessionFactory.getCurrentSession().update(blog);
		System.out.println("update");
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
}

	@Transactional
	public boolean delete(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public List<Blog> list() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Blog.class);
		List<Blog> list=c.list();
		return list;
	}
	@Transactional
	public Blog get(int id) {
		String hql = "from Blog where id= "+ "'"+ id+"'" ;
		log.debug(hql);
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Blog>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	
	/*@Transactional
	public boolean saveOrUpdate(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			System.out.println("save");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}*/
	
}