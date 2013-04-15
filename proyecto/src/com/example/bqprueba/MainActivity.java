package com.example.bqprueba;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Creation of the user's/password's fields views variables.
		
		final EditText user = (EditText)findViewById(R.id.editText1);
		final EditText pass= (EditText)findViewById(R.id.editText2);
		
		//Creation of the Login button's view
		Button logButton= (Button)findViewById(R.id.button1);
		
		//Implementation of the listener which calls the authentication method when the login button is pressed
		logButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (LoginService.login(user.getText().toString(), pass.getText().toString())==true)
				{
						Intent i= new Intent(getApplicationContext(),Viewer.class);
						changeActivity(i);
				}
			}
		});
		
		
		
	}

	private void changeActivity (Intent i)
	{
		startActivity(i);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
