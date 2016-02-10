package com.asdco.nas.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.asdco.nas.dao.NasServer;
import com.asdco.nas.util.NasServerUtil;

@Path(value = "/Servers")
public class NasServerRest {
	
	@Inject
	NasServerUtil util;
	
	@GET
	public List<NasServer> getAllServers() {
		return util.getAllServers();
	}

	@PUT @Path("/register")
	public String registerServer(final NasServer newServer) {
		return util.registerServer(newServer);
	}
}
