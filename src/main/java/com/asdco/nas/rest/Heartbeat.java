package com.asdco.nas.rest;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import com.asdco.nas.dao.HeartbeatLog;

//The @Stateless EJB annotation tells the server that any actions (specifically JPA actions) performed by this bean with be transactional
@Stateless
//The @Path JAX-RS annotation tells the server to look at this controller if anyone hits up "http://serverAddress/Heartbeat" 
@Path(value = "/Heartbeat")
public class Heartbeat implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * The @PersistenceContext JPA annotation without any arguments tells the
	 * server to create an entity manager using the default persistence unit
	 * "primary"
	 */
	@PersistenceContext
	EntityManager em;

	/**
	 * Main endpoint for a server to call home. An HTTP GET call to
	 * http://serverAddress/NasNexus/Heartbeat/whateverIdTheServerIs
	 * 
	 * @return just an OK for now
	 */
	@GET @Path("{serverId}")
	public String getOK(@PathParam("serverId") String serverId, @Context HttpServletRequest request) {
		//create a new heartbeat log entry
		HeartbeatLog entry = new HeartbeatLog();
		
		//add the server id that was provided by the client in the GET request path
		entry.setServerId(serverId);
	    
		//add the address that the request came from
		entry.setVisibleIP(request.getRemoteHost());

		//save it to the database
		em.persist(entry);
		
		return "OK server " + serverId + " at " + request.getRemoteHost();
	}
}
