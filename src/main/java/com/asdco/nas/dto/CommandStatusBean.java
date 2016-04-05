package com.asdco.nas.dto;

import java.util.Calendar;

public class CommandStatusBean {
	Long id;

	Long NasServerId;

	int CmdIsDone;

	Calendar CmdCreationDate;

	Long cmdId;

	public Long getCmdId() {
		return cmdId;
	}

	public void setCmdId(Long cmdId) {
		this.cmdId = cmdId;
	}

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

}
