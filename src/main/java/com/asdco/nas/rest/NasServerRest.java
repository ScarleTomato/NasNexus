package com.asdco.nas.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.asdco.nas.dao.NasServer;
import com.asdco.nas.util.JpaUtil;
import com.asdco.nas.util.NasServerUtil;

@Path(value = "/Servers")
public class NasServerRest {

	private static final String THE_SERVER_ID_FOR = "The server Id for ";
	@Inject
	NasServerUtil util;
	@Inject
	JpaUtil jpaUtil;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listAll")
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

		return THE_SERVER_ID_FOR + name + " is " + s;
	}

	@GET
	@Path("/register/{serverName}")
	public String registerServer(@PathParam("serverName") String name) {
		NasServer newServer = new NasServer();
		newServer.setName(name);
		return util.registerServer(newServer);
	}

}
