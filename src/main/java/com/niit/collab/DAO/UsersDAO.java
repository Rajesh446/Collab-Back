package com.niit.collab.DAO;

import java.util.List;

import com.niit.collab.model.Users;

public interface UsersDAO
{

	public boolean save(Users users);
	
	public boolean update(Users users);
	
	public Users validate(int id,String password);
	
	public Users get(int id);
	
	public List<Users> getAllUsers();
	
	
}
