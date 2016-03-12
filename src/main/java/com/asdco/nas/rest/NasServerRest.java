package com.asdco.nas.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asdco.nas.dao.NasServer;
import com.asdco.nas.util.NasServerUtil;

@Path(value = "/Servers")
public class NasServerRest {
	
	@Inject
	NasServerUtil util;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NasServer> getAllServers() {
		return util.getAllServers();
	}
	
	@GET @Path("/add")
	public String addServer() {
		return "Server has been added.";
	}

	
	@PUT @Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	public String registerServer(final NasServer newServer) {
		return util.registerServer(newServer);
	}
}
