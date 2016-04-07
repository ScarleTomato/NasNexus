package com.asdco.nas.client;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		Properties properties = new Properties();
		
		properties.setProperty("id", "1");
		properties.setProperty("name", "openPaint");
		properties.setProperty("description", "mspaint.exe");
		FileWriter writer = null;
		try {
			writer = new FileWriter("db.properties.command1");
			properties.store(writer,"Author: Joseph Yarbrough");
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if (writer != null){
				try{
					writer.close();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		System.out.println("Done");
	}
}
