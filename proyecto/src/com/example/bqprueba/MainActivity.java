package com.example.bqprueba;



import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.android.AuthActivity;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.TokenPair;

public class MainActivity extends Activity {
	
	//Dropbox's app keys
	final static private String APP_KEY = "uhlkee8nrzzzfjz";
    final static private String APP_SECRET = "lzvbu1cwhau354v";

    //Used for accesing shared preferenced's variable
    final static private String ACCOUNT_PREFS_NAME = "prefs";
    final static private String ACCESS_KEY_NAME = "ACCESS_KEY";
    final static private String ACCESS_SECRET_NAME = "ACCESS_SECRET";
    
    //Dropbox's session Access' type.
    final static private AccessType ACCESS_TYPE = AccessType.APP_FOLDER;
    
    //Dropbox's auth session
    DropboxAPI<AndroidAuthSession> mApi;
    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Creation of new session callint buildSession method.
        AndroidAuthSession session = buildSession();
        mApi = new DropboxAPI<AndroidAuthSession>(session);

		setContentView(R.layout.activity_main);
		

		
		//Creation of the Login and BookView button's view
		Button logButton= (Button)findViewById(R.id.button1);
		Button bookButton = (Button)findViewById(R.id.button2);
	
		
		//Implementation of the listener which calls the authentication method when the login button is pressed
		logButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Starts dropbox Authentication
		                    mApi.getSession().startAuthentication(MainActivity.this);
	
			}
		});
		
		//Mocked activity's change to view Books
		if (mApi.getSession().isLinked()==false)
		{
				
				bookButton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(getApplicationContext(),Viewer.class);
						
						changeActivity(i);
						
					}
				});
		}
		
		
	}

	 private String[] getKeys() {
		 //Retrieves Dropbox's app key and secret key from sharedpreferences and returns it in an Array.
	        SharedPreferences prefs = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
	        String key = prefs.getString(ACCESS_KEY_NAME, null);
	        String secret = prefs.getString(ACCESS_SECRET_NAME, null);
	        if (key != null && secret != null) {
	        	String[] ret = new String[2];
	        	ret[0] = key;
	        	ret[1] = secret;
	        	return ret;
	        } else {
	        	return null;
	        }
	    }

	 
	 
	    private void storeKeys(String key, String secret) {
	        // Store keys in sharedpreferences variable.
	        SharedPreferences prefs = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
	        Editor edit = prefs.edit();
	        edit.putString(ACCESS_KEY_NAME, key);
	        edit.putString(ACCESS_SECRET_NAME, secret);
	        edit.commit();
	    }

	  
	   
	private AndroidAuthSession buildSession() {
		//Main method, creates session with user's data.
        AppKeyPair appKeyPair = new AppKeyPair(APP_KEY, APP_SECRET);
        AndroidAuthSession session;

        String[] stored = getKeys();
        if (stored != null) {
            AccessTokenPair accessToken = new AccessTokenPair(stored[0], stored[1]);
            session = new AndroidAuthSession(appKeyPair, ACCESS_TYPE, accessToken);
        } else {
            session = new AndroidAuthSession(appKeyPair, ACCESS_TYPE);
        }

        return session;
    }
	
	private void changeActivity (Intent i)
	{
		
		//Method userd for changing betweed activities when called
		startActivity(i);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
