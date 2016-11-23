package com.niit.collab.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collab.DAO.*;
import com.niit.collab.model.Friend;

@RestController
public class FriendController 

{

@Autowired
private FriendDAO friendDAO;

@Autowired

private UsersDAO usersDAO; 

@RequestMapping(value="/sendrequest/{fid}", method=RequestMethod.POST)
public ResponseEntity<Friend> newfriend(Friend friend,@PathVariable("fid")int fid,HttpSession session)
{
	friend.setFriendid(fid);
	int uid = (Integer) session.getAttribute("uid");
	friend.setUserid(uid);
	friend.setStatus('n');
	friendDAO.Save(friend);
	return new ResponseEntity<Friend>(friend,HttpStatus.OK);
}


	
	
	
	
}
