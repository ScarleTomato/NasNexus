package com.asdco.nas.client;

public class App {
	
	public static void main(String[] args) {
		System.out.println("Hey!");
		new NasNexusClient().sendHeartbeat();
		new HttpClient().put(url, object)
	}
}
