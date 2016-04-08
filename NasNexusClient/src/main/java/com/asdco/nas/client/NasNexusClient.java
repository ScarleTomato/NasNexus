package com.asdco.nas.client;

import com.asdco.nas.dto.CommandStatusBean;
import com.asdco.nas.dto.HeartbeatBean;
import com.asdco.nas.util.ClientUtil;
import com.asdco.nas.util.JsonUtil;

public class NasNexusClient {

	HttpClient httpClient = new HttpClient();

	public void sendHeartbeat() {
		String name = "Server1";
		System.out.println(name);
		String line = httpClient.get("http://localhost:8080/NasNexus/Heartbeat/" + name);
		HeartbeatBean r = JsonUtil.fromJsonString(line, HeartbeatBean.class);
		while (r.getNumOfCommands() > 0) {
			System.out.println("Getting next command bean....");
			line = httpClient.get("http://localhost:8080/NasNexus/Command/next?server=" + name);
			CommandStatusBean commandStatusBean = JsonUtil.fromJsonString(line, CommandStatusBean.class);
			commandStatusBean.setCmdIsDone(ClientUtil.runServerCommand(commandStatusBean.getCmdId()));
			System.out.println("cmdIdDone = " + commandStatusBean.getCmdIsDone());
			if (commandStatusBean.getCmdIsDone() == 1) {
				line = httpClient.get("http://localhost:8080/NasNexus/Command/update/done?statusId="
						+ commandStatusBean.getId() + "&serverName=" + name);
				r.setNumOfCommands(Long.valueOf(line));

			}

		}
	}
}
