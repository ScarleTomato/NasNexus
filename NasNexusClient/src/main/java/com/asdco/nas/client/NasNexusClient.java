package com.asdco.nas.client;


public class NasNexusClient {
	
	HttpClient httpClient = new HttpClient();
	
	public int sendHeartbeat() {
		System.out.println("Sending heartbeat...");
		System.out.println(httpClient.get("http://localhost:8080/NasNexus/Heartbeat/20"));
		return 0;
	}
}
