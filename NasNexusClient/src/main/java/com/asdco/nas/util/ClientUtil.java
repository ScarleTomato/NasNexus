package com.asdco.nas.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import com.asdco.nas.dto.ServerCommandBean;

public class ClientUtil {

	public static int runServerCommand(Long cmdId) {
		int isDone = 0;
		//String fileName = "command" + cmdId;
		String fileName = "willNotWork";//should not work.....
		System.out.println("File name = "+ fileName);
		ServerCommandBean bean = new ServerCommandBean();
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(fileName+".properties"));
			bean.setId(Long.valueOf(prop.getProperty("id")));
			bean.setName(prop.getProperty("name"));
			bean.setDescription(prop.getProperty("description"));
			isDone = runCommand(bean);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		
		return isDone;
	}

	private static int runCommand(ServerCommandBean bean) {
		try {
		ProcessBuilder pb = new ProcessBuilder(bean.getDescription());
		pb.redirectErrorStream(true);
		Process exec = pb.start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));
		System.out.println(bean.getName());
		System.out.println("Process exited with "+exec.waitFor());
		
		
		}catch(IOException e){
			e.printStackTrace();
		} catch (InterruptedException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		
		
		return 1;
	}

//	private static ServerCommandBean getServerCommandBean(Long id) {
//		ServerCommandBean bean = new ServerCommandBean();
//		Properties properties = new Properties();
//		try {
//			FileReader reader = new FileReader("properties");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return bean;
//	}

	public static Calendar getTimeStamp() {
		Calendar timeStamp = new GregorianCalendar();
		return timeStamp;
	}

	private void command1() {

		// methodToCall

		try {
			String command = "mspaint.exe";
			ProcessBuilder pb = new ProcessBuilder(command);
			pb.redirectErrorStream(true);
			Process exec = pb.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));
			String text = "Opening paint";
			while ((text = br.readLine()) != null) {
				System.out.println(text);
			}
			// isDone = 1;
			System.out.println("Process exited with " + exec.waitFor());
		} catch (IOException | InterruptedException exp) {
			exp.printStackTrace();
		}
	}
}
