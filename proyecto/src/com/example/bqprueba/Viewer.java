package com.example.bqprueba;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bqprueba.BookLoaderService;


public class Viewer extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewer);
	
		final Book[] data= BookLoaderService.getBookList();
				
		//Creation of the book listview's view
		ListView bookList= (ListView) findViewById(R.id.listView1);
		
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
		
	}
}
