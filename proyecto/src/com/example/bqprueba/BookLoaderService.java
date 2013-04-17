package com.example.bqprueba;

import java.io.File;
import java.util.Date;


import com.example.bqprueba.Book;

public class BookLoaderService {
//Implemets methods used when getting the book's list from Dropbox's folder.
	
	public static Book[] getBookList()
	{
		//Creating variables
		
		Book b= new Book("tej.epuf","cTejedores de cabellos", "2000-01-03","path/tej.epuf");
		
		
		Book b2= new Book("umsf.epuf","bUn mundo sin fin", "2000-01-01","path/umsf.epuf");
		
	
		Book b3= new Book("got.epuf","aJuego de Tronos", "2000-01-02","path/got.epuf");
		
		
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
