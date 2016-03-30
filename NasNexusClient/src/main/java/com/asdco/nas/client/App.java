package com.asdco.nas.client;

import com.asdco.nas.dto.HeartbeatResponse;
import com.asdco.nas.util.JsonUtil;



public class App {

	HttpClient HttpClient;

	public static void main(String[] args) {
		System.out.println("Hey!");
		new NasNexusClient().sendHeartbeat();
		//parse response from heartbeat
		
		//If Number of commands: 0 Do nothing
		System.out.println("Getting next command...");
		new HttpClient().get("http://localhost:8080/NasNexus/Command/next?server=Server1");
		new HttpClient().get("http://localhost:8080/NasNexus/Command/list?serverId=10");
		String line = new HttpClient().get("http://localhost:8080/NasNexus/Heartbeat/10");
		HeartbeatResponse response = JsonUtil.fromJsonString(line,HeartbeatResponse.class);
		
		//Else not 0 get next command till Number of commands is 0
			//Before running a command get (recived command)time stamp and send to nexus
			//Run command
			//Get (commandComplete) time stamp and send to nexus
		  System.out.println("Done");
		 
		
		
	}

}
