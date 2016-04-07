package com.asdco.nas.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClientUtil {

	public static int runCommand(Long cmdId) {
		int isDone = 0;
		try {
			// run command
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
			    isDone = 1;
			    System.out.println("Process exited with " + exec.waitFor());
			} catch (IOException | InterruptedException exp) {
			    exp.printStackTrace();
			}
			
			return isDone;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static Calendar getTimeStamp() {
		Calendar timeStamp = new GregorianCalendar();
		return timeStamp;
	}

	private void command1(){
		
		//methodToCall
		
		try {
		    String command = "paint.exe"; 
		    ProcessBuilder pb = new ProcessBuilder(command);
		    pb.redirectErrorStream(true);
		    Process exec = pb.start();

		    BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));
		    String text = "Opening paint";
		    while ((text = br.readLine()) != null) {
		        System.out.println(text);
		    }

		    System.out.println("Process exited with " + exec.waitFor());
		} catch (IOException | InterruptedException exp) {
		    exp.printStackTrace();
		}
	}
}
