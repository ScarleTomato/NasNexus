package com.asdco.nas.client;


public class App {

	public static void main(String[] args) {
		System.out.println("Hey!");
		NasNexusClient nasNexusClient= new NasNexusClient();
		System.out.println("Getting bean...");
		nasNexusClient.sendHeartbeat();
		
		
		
		
	}

}
