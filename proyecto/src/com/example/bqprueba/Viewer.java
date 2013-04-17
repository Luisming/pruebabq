package com.example.bqprueba;

import java.util.Comparator;

import android.app.Activity;
import com.example.bqprueba.BookLoaderService;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bqprueba.BookLoaderService;


public class Viewer extends Activity{
	
	//Array used to store the files found and stored by BookLoaderServier
	private final Book[] data= BookLoaderService.getBookList();
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewer);
		
		final String[] spinner_show= {"Select sorting method","By title","By date"};
		
		final TextView select= (TextView)findViewById(R.id.textView1);
		final TextView select2= (TextView)findViewById(R.id.textView2);
	
		//Creation of the book listview's view
		ListView bookList= (ListView) findViewById(R.id.listView1);
		
		//Creation of the spinner's view.
		Spinner despList= (Spinner) findViewById(R.id.spinner1);
		
		
		
		//Creation of the listener which shows the Book's front then an element of the ListView is clicked.
		ListView listView = (ListView)findViewById(R.id.listView1);
		
		//Setting of the adapter used to show Book's information
		final ArrayAdapter<Book> listAdapter=  new ArrayAdapter<Book>(this,android.R.layout.simple_list_item_1,data);
       
		listView.setAdapter(listAdapter);
        
		
       //Implementation of listView's click listener actions. (Read book/Show front of the book) In this case shows Date and Filename
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            		select.setText( data[position].getDate());
            		select2.setText(data[position].getTitle());
            }

			
          });
	
        
		//Implementation of spinner
		
        Spinner spinView= (Spinner) findViewById(R.id.spinner1);
        
        //Creation of spinner's ArrayAdapter
        ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinner_show);
        
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spinView.setAdapter(spinAdapter);
        
        	//Implementation of Spinner's click listener action.
        	spinView.setOnItemSelectedListener(new OnItemSelectedListener() {

        		
				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
					//If spinner's position is 0 Books will be sort by Title
					
					if (position==1)
					{
						select.setText(spinner_show[position]);
					
						//Used comparator generic class to sort by title
						listAdapter.sort(new Comparator<Book>() {
								public int compare(Book object1, Book object2) {
									return object1.getTitle().compareTo(object2.getTitle());
								};
					
						});
					
					}
					
					//If Spinner's position is 1 Books will be sort by Date
					else if (position==2)
					{
							listAdapter.sort(new Comparator<Book>() {
								public int compare(Book object1, Book object2) {
									return object1.getDate().compareTo(object2.getDate());
								};
						
						});
					}
					//Notification about changes in listAdapter
					listAdapter.notifyDataSetChanged();
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		
        	
	};
	
	
	
	}

