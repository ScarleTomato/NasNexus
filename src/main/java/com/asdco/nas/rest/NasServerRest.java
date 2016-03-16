package com.asdco.nas.rest;

import java.util.List; 
import java.util.Calendar;
import java.util.HashMap;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import com.asdco.nas.dao.HeartbeatLog;
import com.asdco.nas.dao.NasServer;
import com.asdco.nas.util.JpaUtil;
import com.asdco.nas.util.NasServerUtil;

@Path(value = "/Servers")
public class NasServerRest {
	
	@Inject
	NasServerUtil util;
	@Inject
	JpaUtil jpaUtil;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NasServer> getAllServers() {
		return util.getAllServers();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getServerId")
	public String getServerIdByName(@QueryParam("name") String name) {
		
		
		NasServer namedServer = util.getServerByName(name);
		Long serverId = namedServer.getId();
		String s = String.valueOf(serverId);
		
		return "The server Id for "+name+" is "+s;
	}
	


	
	@GET @Path("/register/{serverId}")
	public String registerServer(@PathParam("serverId") String name) {
		NasServer newServer = new NasServer();
		newServer.setName(name);
		return util.registerServer(newServer);
	}
	
	
}
