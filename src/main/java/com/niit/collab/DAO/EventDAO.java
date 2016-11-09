package com.niit.collab.DAO;

import com.niit.collab.model.Event;

public interface EventDAO 

{

	public boolean save(Event event);
	
	public boolean update(Event event);
	
	public boolean delete(Event event);
	
	
	
}
