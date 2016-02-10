package com.asdco.nas.rest;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.asdco.nas.dao.HeartbeatLog;

//The @Stateless EJB annotation tells the server that any actions (specifically JPA actions) performed by this bean with be transactional
@Stateless
//The @Path JAX-RS annotation tells the server to look at this controller if anyone hits up "http://serverAddress/Heartbeat" 
@Path(value = "/Heartbeat")
public class Heartbeat implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* 
	 * The @PersistenceContext JPA annotation without any arguments
	 * tells the server to create an entity manager using the
	 * default persistence unit "primary"
	 */
	@PersistenceContext
	EntityManager em;

	/*
	 * The @GET JAX-RS annotation without any arguments tells the
	 * Heartbeat Controller to run this method for any HTTP GET requests
	 */
	@GET
	public String getOK() throws Exception {
		HeartbeatLog entry = new HeartbeatLog();
		entry.setServerId("20");
		entry.setVisibleIP("20.20.20.20");
		em.persist(entry);
		return "OK";
	}
}
