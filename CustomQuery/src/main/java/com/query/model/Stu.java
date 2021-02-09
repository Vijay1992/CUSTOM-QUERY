package com.query.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int sid;
	String name;
	String course;
	
}
