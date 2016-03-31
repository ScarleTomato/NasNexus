package com.asdco.nas.dto;

import java.util.Calendar;

public class HeartbeatResponse {
	

	Long id;


	Calendar logDate;


	String serverId;


	String visibleIP;
	
	Long numOfCommands;
	
	Long nextCommand = null;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getLogDate() {
		return logDate;
	}

	public void setLogDate(Calendar logDate) {
		this.logDate = logDate;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getVisibleIP() {
		return visibleIP;
	}

	public void setVisibleIP(String visibleIP) {
		this.visibleIP = visibleIP;
	}

	public Long getNumOfCommands() {
		return numOfCommands;
	}

	public void setNumOfCommands(Long numOfCommands) {
		this.numOfCommands = numOfCommands;
	}

	public Long getNextCommand() {
		return nextCommand;
	}

	public void setNextCommand(Long nextCommand) {
		this.nextCommand = nextCommand;
	}


}
