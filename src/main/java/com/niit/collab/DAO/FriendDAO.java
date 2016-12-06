package com.niit.collab.DAO;

import java.util.List;

import com.niit.collab.model.*;

public interface FriendDAO
{

	public boolean saveOrUpdate(Friend friend);
	/*public boolean Update(Friend friend);*/
	public boolean Delete(Friend friend);
	public Friend getFriend(int id);
	public Friend newrequest(int id);
	
	public List<Friend> list();
	public List<Friend> getfriendlist(int uid);
	public Friend UpdateStatus(String uid,String fid);
	
	
}
