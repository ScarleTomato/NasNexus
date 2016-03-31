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
	@Path("{serverName}")
	public HeartbeatResponse receiveHeartbeat(@PathParam("serverName") String serverName, @Context HttpServletRequest request) {
		
		HeartbeatResponse bean = util.receiveHeartbeat(serverName, request.getRemoteHost());
		
		//bean = HeartbeatUtil.buildBean();// Need to build query last heartbeatLog by server id
		return bean;//pause here
	}
}


