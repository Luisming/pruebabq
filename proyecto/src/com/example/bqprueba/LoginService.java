package com.example.bqprueba;

import java.io.File;

//Implements methods used to authenticate and comunicatewith Dropbox server.

public class LoginService {
	
	//Connects with the Dropbox server and returns true if the user's parameters are correct.
	public static boolean login(String username, String password)
	{
		return true;
		//In this dummy application always returns true. Correct login.
	}

	public static File getFileSystem()
	{//Dummy method which returns the FileSystem used to interact with Dropbox online folder
     //I use f as a "magic" variable which Dropbox gives to the developer to get information of the Dropbox folder.
		File f = new File("path/to/dropbox");
		return f;
		
	}
}
