package com.asdco.nas.client;


public class NasNexusClient {
	
	HttpClient httpClient = new HttpClient();
	
	public int sendHeartbeat() {
		String serverName = "Server1";
		System.out.println("Sending heartbeat from "+serverName+" ...");
		System.out.println(httpClient.get("http://localhost:8080/NasNexus/Heartbeat/"+serverName));
		return 0;
	}
}
