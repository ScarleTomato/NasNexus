package com.asdco.nas.dao;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HeartbeatLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	Long id;

	@Column(insertable = false, updatable = false)
	Calendar logDate;

	@Column
	String serverId;

	@Column
	String visibleIP;

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
}
