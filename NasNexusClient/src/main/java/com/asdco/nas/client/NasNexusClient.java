package com.asdco.nas.client;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


import javax.swing.plaf.synth.SynthSeparatorUI;

import com.asdco.nas.dto.CommandStatusBean;
import com.asdco.nas.dto.HeartbeatBean;
import com.asdco.nas.util.JsonUtil;
import com.asdco.nas.util.ClientUtil;



public class NasNexusClient {

	HttpClient httpClient = new HttpClient();

	/**
	 * public int sendHeartbeat() { String serverName = "Server1";
	 * System.out.println("Sending heartbeat from "+serverName+" ...");
	 * System.out.println(httpClient.get(
	 * "http://localhost:8080/NasNexus/Heartbeat/"+serverName)); return 0; }
	 **/

	public String sendHeartbeat() {
		String name = "Server1";
		String line = httpClient.get("http://localhost:8080/NasNexus/Heartbeat/"+name);
		HeartbeatBean r = JsonUtil.fromJsonString(line, HeartbeatBean.class);
		while (r.getNumOfCommands() > 0) {
			// get next cmd
			System.out.println("Getting next command bean....");
			line = httpClient.get("http://localhost:8080/NasNexus/Command/next?server="+name);
			CommandStatusBean commandStatusBean = JsonUtil.fromJsonString(line, CommandStatusBean.class);


			
			
			//httpClient.get("http://localhost:8080/NasNexus/Command/next?server=" + name);
			// run cmd
			// if no errors notify complete
			// get and set number of r.serNumberOfCommands
			
			r.setNumOfCommands(0L);//infinite loop kill switch.
			
			
		}
		return "Hello world";
		// String newline = new
		// HttpClient().get("http://localhost:8080/NasNexus/Command/list?serverId=10");
		// System.out.println(newline+"Hello world");
	}
}
