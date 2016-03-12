package com.asdco.nas.rest;

import java.util.List;
import java.util.Calendar;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
	/**private Calendar NasServer(String serverId) {
		//create a new Server entry log entry
		logNasServer entry = new logNasServer();

		//add the server id that was provided by the client in the GET request e
		entry.setServerId(serverId);
	}
	Im trying to get it so that the server will read the ServerId and output the serverId in the text.
	**/
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NasServer> getAllServers() {
		return util.getAllServers();
	}
	
	private Long NasServer(Long serverId) {
		//create a new NasServer entry
		NasServer entry = new NasServer();

		//add the server id that was provided by the client in the GET request e
		entry.setId(serverId);

		//save it to the database
		jpaUtil.persist(entry);
		
		return entry.getId();
	}
	
	@GET @Path("/add/{ServerId}")
	public String addServer(Long serverId) {
		NasServer.setId(serverId);
		return "The server"+serverId+" has been added.";
	}

	
	@PUT @Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	public String registerServer(final NasServer newServer) {
		return util.registerServer(newServer);
	}
}
