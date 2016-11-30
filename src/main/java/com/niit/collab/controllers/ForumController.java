package com.niit.collab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collab.DAO.ForumDAO;
import com.niit.collab.model.Forum;

@RestController
public class ForumController
{

	@Autowired
	ForumDAO forumDAO;
	
	@Autowired
	
	Forum forum;
	
	
	
	@RequestMapping(value="/CreateForum" ,method=RequestMethod.POST)
	public ResponseEntity<Forum> addforum(@RequestBody Forum forum) 
	{
	
		System.out.println("Creation of FORUM");
		
		forumDAO.save(forum);
		
		return new ResponseEntity<Forum>(forum ,HttpStatus.OK);
	}
	
	
	/*@RequestMapping(value="/UpdateForum" ,method=RequestMethod.PUT)
	public ResponseEntity<Forum> updateForum(@RequestBody Forum forum) 
	{
	
		System.out.println("updating of FORUM");
		
		forumDAO.update(forum);
		
		return new ResponseEntity<Forum>(forum ,HttpStatus.OK);
	}*/
	
	
	@RequestMapping(value="/DeleteForum/{id}" ,method=RequestMethod.DELETE)
	public ResponseEntity<Forum> deleteForum(Forum forum,@PathVariable("id") int id) 
	{
		System.out.println("deleting of FORUM");
		forumDAO.delete(forum);
		return new ResponseEntity<Forum>(forum ,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/Forum" , method=RequestMethod.GET)
	public ResponseEntity<List<Forum>> listforum(){
		System.out.println("list of forum");
		List<Forum> forum =forumDAO.list();
		return new ResponseEntity<List<Forum>>(forum,HttpStatus.OK);
	}
	
	
}

	
	
	
	

