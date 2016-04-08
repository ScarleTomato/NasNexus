//package com.asdco.nas.client;
//
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Date;
//import java.util.Properties;
//
//public class Test {
//
//	public static void main(String[] args) {
//		String line = getInfo();
//	}
//	public ServerCommandBean
//	InputStream inputStream;
//	public String getInfo() throws IOException {
//		String id;
//		String name;
//		String description;
//		
//		try{
//		Properties prop = new Properties();
//		String fileName = "conf.properties";
//		inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
//		if (inputStream != null) {
//			prop.load(inputStream);
//		} else {
//			throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
//		}
//
//		Date time = new Date(System.currentTimeMillis());
//
//		// get the property value and print it out
//		id = prop.getProperty("id");
//		System.out.println("id = " + id);
//		name = prop.getProperty("name");
//		System.out.println("name = " + name);
//		description = prop.getProperty("description");
//		System.out.println("description = " + description);
//
//	}catch(
//
//	Exception e)
//	{
//		System.out.println("Exception: " + e);
//	}finally
//	{
//		inputStream.close();
//	}
//		return "id = " + id+", name = " + name+", description = " + description;
//	}
//
//	public static void writeToFile(String[] args) {
//		Properties properties = new Properties();
//
//		properties.setProperty("id", "1");
//		properties.setProperty("name", "openPaint");
//		properties.setProperty("description", "mspaint.exe");
//		FileWriter writer = null;
//		try {
//			writer = new FileWriter("db.properties.command1");
//			properties.store(writer, "Author: Joseph Yarbrough");
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (writer != null) {
//				try {
//					writer.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		System.out.println("Done");
//	}
//}
