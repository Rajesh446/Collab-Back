package com.niit.collab.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.spi.LoggerFactory;
import org.apache.tomcat.jni.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collab.DAO.FriendDAO;
import com.niit.collab.DAO.UsersDAO;
import com.niit.collab.model.Friend;
import com.niit.collab.model.Users;

@RestController
public class FriendController {
	
	/*private static final Logger logger = LoggerFactory.getlogger(FriendController.class);*/
	
@Autowired
private FriendDAO friendDAO;
@Autowired
private UsersDAO usersDAO;
@Autowired
private Users users;
@Autowired
HttpSession session;
@Autowired
private Friend friend; 
private List<Friend> Users;

@PostMapping(value="/sendrequest/{fid}")

public ResponseEntity<Friend> newfriend(Friend friend,@PathVariable("fid") int fid,HttpSession session){
	friend.setFriendid(fid);
	int uid = (Integer) session.getAttribute("uid");
	friend.setUserid(uid);
	friend.setStatus('n');
	friendDAO.saveOrUpdate(friend);
	return new ResponseEntity<Friend>(friend,HttpStatus.OK);
}

@GetMapping(value="/myfriends")
public ResponseEntity<List<Friend>> myfriends(HttpSession session){
	//int uid =(Integer) session.getAttribute("uid");
	//List<Users> u1 = null;
	List<Friend> list=friendDAO.getfriendlist(users.getId());
	/*System.out.println(list.size());
	for(int i=0;i < list.size();i++){
		System.out.println(i);
		Friend friends = list.get(i);
		System.out.println("friend");
		 int f = friends.getFriendid();
		u1= usersDAO.getuser(f);
	    
		//System.out.println(u1);
	}*/
	return new ResponseEntity<List<Friend>>(list,HttpStatus.OK);

}
@PostMapping(value="/acceptrequest/{fid}")
public ResponseEntity<Friend> acceptFriendFriendRequest(@PathVariable("fid")String fid) {
  
	String loggedInuid=(String)session.getAttribute("userLogged");
	saveOrUpdateRequest(fid,"A");
	return new ResponseEntity<Friend>(friend, HttpStatus.OK);

//public ResponseEntity<Friend> acceptfriend(HttpSession session){
	/*int fid = (Integer) session.getAttribute("uid");
	Friend friend =friendDAO.newrequest(fid);
	friend.setStatus('a');
	friendDAO.saveOrUpdate(friend);
	return new ResponseEntity<Friend>(friend,HttpStatus.OK);*/
}/*
private void saveOrUpdateRequest(String fid, String string) {
	// TODO Auto-generated method stub
	
}*/

private void saveOrUpdateRequest(String fid, String string) {
	// TODO Auto-generated method stub
	
}

@PostMapping(value="/rejectrequest")
public ResponseEntity<Friend> rejectfriend(HttpSession session){
	int fid = (Integer) session.getAttribute("uid");
	Friend friend =friendDAO.newrequest(fid);
	friend.setStatus('r');
	friendDAO.saveOrUpdate(friend);
	return new ResponseEntity<Friend>(HttpStatus.OK);
}
}