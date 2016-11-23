package com.niit.collab.DAO;

import java.util.List;

import com.niit.collab.model.*;

public interface FriendDAO
{

	public boolean Save(Friend friend);
	public boolean Update(Friend friend);
	public boolean Delete(Friend friend);
	public Friend getFriend(int id);
	public Friend newrequest(int id);
	public List<Friend> getFriendlist();
	public List<Friend> list();
	
	
}
