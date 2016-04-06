package com.asdco.nas.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClientUtil {
	
	public static int runCommand(Long cmdId){
		int isDone =0;
		try {
			//run command
			isDone=1;
			return isDone;
		}catch (Exception e){
			throw new RuntimeException(e);
		}
		
	}


	public static Calendar getTimeStamp() {
		Calendar timeStamp = new GregorianCalendar();
		return timeStamp;
	}
	
	
}
