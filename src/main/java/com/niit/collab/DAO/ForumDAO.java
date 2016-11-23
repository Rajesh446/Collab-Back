package com.niit.collab.DAO;

import java.util.List;

import com.niit.collab.model.Forum;

public interface ForumDAO

{

	public boolean save(Forum forum);
	public boolean update(Forum forum);
	public boolean delete(Forum forum);
	public List<Forum>list();
	public Forum getforum(int id);
	
}
