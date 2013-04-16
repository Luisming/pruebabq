package com.example.bqprueba;

import android.app.Activity;
import com.example.bqprueba.BookLoaderService;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bqprueba.BookLoaderService;


public class Viewer extends Activity{
	
	//Array used to store the files found and stored by BookLoaderServier
	private final Book[] data= BookLoaderService.getBookList();
	//Used to show the Book's title in the layout's listview.
	private final String data_show[]=new String[data.length];
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewer);
		
		final TextView select= (TextView)findViewById(R.id.textView1);
		
	
		//Creation of the book listview's view
		ListView bookList= (ListView) findViewById(R.id.listView1);
		
		//Creation of the spinner's view.
		Spinner despList= (Spinner) findViewById(R.id.spinner1);
		
	
		populateData_show();
		
		
		//Creation of the listener which shows the Book's front then an element of the ListView is clicked.
		ListView listView = (ListView)findViewById(R.id.listView1);
		
		//Set of the adapter used to show Book's information
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data_show));
        
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
             select.setText( data_show[position]);
            }

			
          });
	
		
		//Implementation of spinner's ArrayAdapter
		
		
		
	};
	
	private void populateData_show()
	{//Populates the String Array used to show the Books' titles in the ListView
		for (int i=0; i<data.length; i++)
		{
			data_show[i]=data[i].getTitle();
			
		}
	}
	public void sortByDate()
	{//unimplemeted method which sorts the Book's listview by Date
		
	}
		
	public void sortByFileName()
	{
	//Unimplemented method which sorts the Book0s listview by File Name
	}
	
	}

