package com.example.bqprueba;

import java.io.File;
import java.util.Date;

import com.example.bqprueba.LoginService;
import com.example.bqprueba.Book;

public class BookLoaderService {
//Implemets methods used when getting the book's list from Dropbox's folder.
	
	public static Book[] getBookList()
	{
		//Creating variables
		Date d=new Date(1987, 2, 3);
		Book b= new Book("tej.epuf","Tejedores de cabellos", d,"path/tej.epuf");
		
		Date d1=new Date(1987, 2, 5);
		Book b2= new Book("umsf.epuf","Un mundo sin fin", d,"path/umsf.epuf");
		
		Date d2=new Date(1987, 2, 4);
		Book b3= new Book("got.epuf","Juego de Tronos", d,"path/got.epuf");
		
		
		//Variable where all Book entities are stored, in this case 3 entities of Book created to mock
		//the behavior of a real system where all .epuf files would be analysed, then a Book entity would
		//be created with the book's data and stored in books array.
		Book[] books= new Book[3];
		
		//Mocking the behavior of pupulating books array
		books[0]=b;
		books[1]=b2;
		books[2]=b3;
		
		
		
		

		//Return of the array full of books (.epuf files about dropboxFileSystem gives us information)
		return books;
		
	}
	
	
	
}
