package com.asdco.nas.dto;

import java.util.Calendar;

import javax.persistence.Column;

public class CommandstatusResponse {
	Long id;
	
	Long NasServerId; 
	
	Long CmdId;
	
	int CmdIsDone;
	
	Calendar CmdCreationDate;
	
	Calendar ServerRetrievedCmd;
	
	Calendar ServerCompleatedCmd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNasServerId() {
		return NasServerId;
	}

	public void setNasServerId(Long nasServerId) {
		NasServerId = nasServerId;
	}

	public Long getCmdId() {
		return CmdId;
	}

	public void setCmdId(Long cmdId) {
		CmdId = cmdId;
	}

	public int getCmdIsDone() {
		return CmdIsDone;
	}

	public void setCmdIsDone(int cmdIsDone) {
		CmdIsDone = cmdIsDone;
	}

	public Calendar getCmdCreationDate() {
		return CmdCreationDate;
	}

	public void setCmdCreationDate(Calendar cmdCreationDate) {
		CmdCreationDate = cmdCreationDate;
	}

	public Calendar getServerRetrievedCmd() {
		return ServerRetrievedCmd;
	}

	public void setServerRetrievedCmd(Calendar serverRetrievedCmd) {
		ServerRetrievedCmd = serverRetrievedCmd;
	}

	public Calendar getServerCompleatedCmd() {
		return ServerCompleatedCmd;
	}

	public void setServerCompleatedCmd(Calendar serverCompleatedCmd) {
		ServerCompleatedCmd = serverCompleatedCmd;
	}

}
