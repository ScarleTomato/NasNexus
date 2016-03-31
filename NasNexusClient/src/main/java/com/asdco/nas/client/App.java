package com.asdco.nas.client;

import com.asdco.nas.dto.HeartbeatResponse;
import com.asdco.nas.util.JsonUtil;



public class App {

	HttpClient HttpClient;

	public static void main(String[] args) {
		System.out.println("Hey!");
		new NasNexusClient().sendHeartbeat();
		System.out.println("Getting bean...");
		String line = new HttpClient().get("http://localhost:8080/NasNexus/Heartbeat/Server1");
		HeartbeatResponse response = JsonUtil.fromJsonString(line,HeartbeatResponse.class);
		//next up: read if nextCommand != 0
	}

}
