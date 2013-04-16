package com.example.bqprueba;

import java.util.Date;

public class Book {
//Stores the book's attributes and implements methods to get information about them.
	
	private String fileName;
		//Book's filename
	private String title;
		//Book's title.
	private Date creationDate;
		//Book's creation date
	private String pathToBook;
		//Path to book inside Dropbox folder. 
	
	public Book(String n, String t, Date d, String p)
	{
		fileName=n;
		title=t;
		creationDate= d;
		pathToBook=p;
		
	}
	
	public String getfileName()
	{
		//Returns the book's fileName
		return fileName;
	}
	
	public String getTitle()
	{
		//Returns the book's Title
		return title;
	}
	
	public Date getcreationate()
	{
		//Returns the book's creationDate
		return creationDate;
	}
	
	public String getpathToBook()
	{
		//Returns the book's file path inside Dropbox folder.
		return pathToBook;
	}
	
	
}
