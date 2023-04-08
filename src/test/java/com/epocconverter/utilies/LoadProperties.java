package com.epocconverter.utilies;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;


public class LoadProperties {
	
	public static Properties loadproperties1(String filepath) throws IOException 
	{
		
		File f=new File(filepath); //for making connection
		FileReader fr=new FileReader(f); //reading data char by char
		Properties pr= new Properties();
		pr.load(fr);
		return pr;
		
				
		
		
	}

}
