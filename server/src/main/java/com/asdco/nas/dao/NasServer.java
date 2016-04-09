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
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({ @NamedQuery(name = "NasServer.findAll", query = "select s from Servers s"),
		@NamedQuery(name = "NasServer.findByName", query = "select s from Servers s where s.name=:name")

})
@Entity(name = "Servers")
@XmlRootElement
public class NasServer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column
	String name;

	@Column
	String address;

	@Column
	String description;

	@Version
	@Column(insertable = false, updatable = false)
	Calendar createdDate;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}
}
