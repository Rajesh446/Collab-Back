package com.niit.collab.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Table
@Component
public class Forum 
{

@Id
@GeneratedValue
private int id;
private String name;
private String topic;
private int userid;
private Date doc;
private String Description;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTopic() {
	return topic;
}
public void setTopic(String topic) {
	this.topic = topic;
}
public int getUserid() {
	return userid;
}
public void setUserid(int uid) {
	this.userid = uid;
}
public Date getDoc() {
	return doc;
}
public void setDoc(Date doc) {
	this.doc = doc;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}


	
	
}
