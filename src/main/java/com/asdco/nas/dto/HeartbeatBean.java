package com.asdco.nas.dto;

import java.util.Calendar;

public class HeartbeatBean {

	Long id;

	Calendar logDate;

	String serverId;

	String visibleIP;

	Long numOfCommands;

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

	public String info() {
		return "Id :" + id + " LogDate : no show  ServerId :" + serverId + " Ip :" + visibleIP + " Number ofCommands :"
				+ numOfCommands;
	}

}
