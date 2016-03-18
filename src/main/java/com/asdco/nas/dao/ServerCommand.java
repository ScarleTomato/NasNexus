package com.asdco.nas.dao;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;


@NamedQueries({
	@NamedQuery(name="ServerCommand.findAll", query="select s from ServerCommand s"),
	@NamedQuery(name="ServerCommand.findByName", query="select s from ServerCommand s where s.name=:name")
	
})

public class ServerCommand implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	/**
	 * ID
	 * cmdName
	 * date created
	 * 
	**/
	
	
	@Id
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long cmdId;
	
	@Column
	String name;
	
	@Version
	@Column(insertable = false, updatable = false)
	Calendar createdDate;
	

	@Column
	String action;
	
	public Long getId() {
		return cmdId;
	}

	public void setId(Long id) {
		this.cmdId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getLogDate() {
		return logDate;
	}

	public void setLogDate(Calendar logDate) {
		this.logDate = logDate;
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	Calendar logDate;
	
	
	
	

}
