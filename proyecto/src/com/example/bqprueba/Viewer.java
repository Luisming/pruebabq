package com.example.bqprueba;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.bqprueba.BookLoaderService;


public class Viewer extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewer);
		
		final Book[] data= BookLoaderService.getBookList();
				
		//Creation of the book listview's view
		ListView bookList= (ListView) findViewById(R.id.listView1);
		
		//Creation of the spinner's view.
		Spinner despList= (Spinner) findViewById(R.id.spinner1);
		
		//Set of the adapter used to show Book's information
		bookList.setAdapter(new ArrayAdapter<Book>(this,android.R.layout.viewer,data));
        
		//Creation of the listener which shows the Book's front then an element of the ListView is clicked.
        
		bookList.setOnItemClickListener(new View.OnItemClickListener() {
            
			public void onItemClick(AdapterView<?> parent, View view, int position, int id) {
			//When Clicked the BookReader's method read is launched to show the front of the .epuf file according to the id
			//Loading the path to book inside Dropbox folder stored in Books array.
				
						BookReader.readBook(data[id].getpathToBook());			
            }
          });
		
		//Implementation of spinner's ArrayAdapter
		String spinnerOptions = {"By Date","By fileName"}
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this, spinnerOptions, R.layout.viewer);
		despList.setAdapter(adapter);
		
		 sp.setOnItemSelectedListener(new OnItemSelectedListener() {
	           
	            public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
	             int position, long id) {
	            
	             //if By Date is selected
	            		SortByDate();
	            		
	            //else By filename is selected
	            		
	            		SortByfileName();
	            }
		
		
	};
	
	public void sortByDate()
	{//unimplemeted method which sorts the Book's listview by Date
		
	}
		
	public void sortByFileName()
	{
	//Unimplemented method which sorts the Book0s listview by File Name
	}
	
	}
}
