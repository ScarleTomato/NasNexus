package com.asdco.nas.client;

import java.util.Arrays;
import java.util.List;

import com.asdco.nas.dto.HeartbeatResponse;
import com.asdco.nas.util.JsonUtil;

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
		HeartbeatResponse r = JsonUtil.fromJsonString(line, HeartbeatResponse.class);
		while (r.getNumOfCommands() > 0) {
			// get next cmd
			System.out.println("Getting next command....");
			String commandData = httpClient.get("http://localhost:8080/NasNexus/Command/next");
			System.out.println(commandData);
			//List<Long> Data = Arrays.asList(str.split("\\s*,\\s*"));
			Long cmdId = 0L;
			Long Id = 0L;

			//httpClient.get("http://localhost:8080/NasNexus/Command/next?server=" + name);
			System.out.println(r.info());
			
			r.setNumOfCommands(0L);//infinite loop kill switch.
			
			// run cmd
			// if no errors notify complete
			// get and set number of r.serNumberOfCommands
		}
		return "Hello world";
		// String newline = new
		// HttpClient().get("http://localhost:8080/NasNexus/Command/list?serverId=10");
		// System.out.println(newline+"Hello world");
	}
}
