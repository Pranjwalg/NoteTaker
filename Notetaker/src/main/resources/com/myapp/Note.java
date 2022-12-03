package com.myapp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Note {
	@Id
private int id;
private String title;
private String content;
private Date addedDate;

}
