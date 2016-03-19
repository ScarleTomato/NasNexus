package com.asdco.nas.dao;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;



@NamedQueries({
	@NamedQuery(name="ServerCommand.findAll", query="select s from ServerCommand s"),
	@NamedQuery(name="ServerCommand.findByName", query="select s from ServerCommand s where s.name=:name")
	
})
@Entity
@Table(name="ServerCommand")
public class ServerCommand implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	/**
	 * 
	 * ID
	 * cmdName
	 * date created
	 * 
	**/
	
	
	@Id
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column
	String name;
	
	@Version
	@Column(insertable = false, updatable = false)
	Calendar logDate;
	

	@Column
	String action;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
	
	
	

}
