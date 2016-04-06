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
	
	public void sendHeartbeat() {
		String name = "Server1";
		String line = httpClient.get("http://localhost:8080/NasNexus/Heartbeat/"+name);
		HeartbeatBean r = JsonUtil.fromJsonString(line, HeartbeatBean.class);
		while (r.getNumOfCommands() > 0) {
			System.out.println("Getting next command bean....");
			line = httpClient.get("http://localhost:8080/NasNexus/Command/next?server="+name);
			CommandStatusBean commandStatusBean = JsonUtil.fromJsonString(line, CommandStatusBean.class);
			commandStatusBean.setCmdIsDone(ClientUtil.runCommand(commandStatusBean.getCmdId()));
			// if no errors notify complete
			if(commandStatusBean.getCmdIsDone()==1){
				//send confirmation to nexus
				 httpClient.get("http://localhost:8080/NasNexus/Command/update/done?statusId="+commandStatusBean.getId()+"&serverName="+name);
					//return number of remaining commands
				
			}
			r.setNumOfCommands(0L);//infinite loop kill switch.
			
			
		}
	}
}
