package com.example.bqprueba;

//Implements methods used to authenticate and comunicatewith Dropbox server.

public class LoginService {
	
	//Connects with the Dropbox server and returns true if the user's parameters are correct.
	public static boolean login(String username, String password)
	{
		return true;
		//In this dummy application always returns true. Correct login.
	}

	public static int getNumberOfFiles()
	{
		//Returns the number of .epuf files inside Dropbox folder.
		return 10;
		//In this dummy application always returns 10.
		
	}
}
