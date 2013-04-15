package com.example.bqprueba;

import java.io.File;

import com.example.bqprueba.LoginService;

public class BookLoaderService {
//Implemets methods used when getting the book's list from Dropbox's folder.
	
	public static Book[] getBookList()
	{
		Book b;
		//Uses getNumberOfFiles method to allocate the neccesary storage space for the Array.
		File dropboxFileSystem= LoginService.getFileSystem();
		
		//Memory allocation, using and unimpmlemented method from the dropboxFileSystem variable to know the number of .epuf files.
		Book[] books= new Book[dropboxFileSystem.getNumberOfEpufFiles()];
		
		//Creation of the Books'Array used to show it in the Viever activity.
		for (int i=0; i<dropboxFileSystem.getNumberOfEpufFiles());i++)
		{
			//Book auxiliar variable creation fromt he data given from dropboxFileSystem
			bk.book(dropboxFileSystem.name, dropboxFileSystem.title, dropboxFileSystem.creation, dropboxFileSystem.path)
		
			//Call to get the next epuf of the epuf list.
			dropboxFileSystem.nextEpuf;
			//Storage of the auxiliar variable
			books[i]=b;	
		}

		//Return of the array full of books (.epuf files about dropboxFileSystem gives us information)
		return books;
		
	}
	
}
