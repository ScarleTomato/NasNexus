package com.asdco.nas.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import com.asdco.nas.dto.ServerCommandBean;

public class ClientUtil {

	public static int runServerCommand(Long cmdId) {
		int isDone = 0;
		String fileName = "command" + cmdId;
		System.out.println("File name = " + fileName);
		ServerCommandBean bean = new ServerCommandBean();
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(fileName + ".properties"));
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
			System.out.println(bean.getName());
			System.out.println("Process exited with " + exec.waitFor());
			return 1;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return 3;
	}

	public static Calendar getTimeStamp() {
		Calendar timeStamp = new GregorianCalendar();
		return timeStamp;
	}

}
