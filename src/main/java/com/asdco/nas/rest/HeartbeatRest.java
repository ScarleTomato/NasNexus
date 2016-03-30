package com.asdco.nas.rest;

import javax.inject.Inject;  
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.asdco.nas.dto.HeartbeatResponse;
import com.asdco.nas.util.HeartbeatUtil;
import com.asdco.nas.dao.HeartbeatLog;

//The @Path JAX-RS annotation tells the server to look at this controller if anyone hits up "http://serverAddress/Heartbeat" 
@Path(value = "/Heartbeat")
public class HeartbeatRest {

	@Inject
	HeartbeatUtil util;

	/**
	 * see {@link HeartbeatUtil#receiveHeartbeat(String, String)}
	 */
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{serverId}")
	public HeartbeatResponse receiveHeartbeat(@PathParam("serverId") String serverId, @Context HttpServletRequest request) {
		util.receiveHeartbeat(serverId, request.getRemoteHost());
		//HeartbeatResponse bean = HeartbeatUtil.buildBean();// Need to build query last heartbeatLog by server id
		return null;
	}
}


