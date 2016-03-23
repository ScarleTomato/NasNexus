package com.asdco.nas.dao;

import java.util.Calendar;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="CommandStatus.findByNasServerId", query="select s from CommandStatus s where s.NasServerId=:ServerId and s.CmdIsDone=0")
	
})

public class CommandStatus {
	@Id
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column
	Long NasServerId; 
	
	@Column
	Long CmdId;
	
	@Column
	int CmdIsDone;
	
	@Column
	Calendar CmdCreationDate;
	
	@Column
	Calendar ServerRetrievedCmd;
	
	@Column
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
