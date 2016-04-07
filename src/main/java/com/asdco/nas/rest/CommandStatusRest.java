package com.asdco.nas.rest;

import java.util.List; 

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.asdco.nas.dao.CommandStatus;
import com.asdco.nas.dto.CommandStatusBean;
import com.asdco.nas.util.CommandStatusUtil;
import com.asdco.nas.util.NasServerUtil;
import com.asdco.nas.util.ServerCommandUtil;

@Path(value = "/Command")
public class CommandStatusRest {
	@Inject
	CommandStatusUtil util;
	
	@Inject
	NasServerUtil nasServerUtil;
	
	@Inject
	ServerCommandUtil serverCommandUtil;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String addCommand(@QueryParam("server") String server,@QueryParam("command") String commandName){
			return util.addCommand(server, commandName); 
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<CommandStatus> getCommands(@QueryParam("serverId") Long serverId){
		return util.getCommandList(serverId);
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/done")
	public Long updateCommandStatus(@QueryParam("statusId") Long id,@QueryParam("serverName")String serverName){
		return util.updateCommandStatus(id, serverName);
		
		
		
		
		//return bean;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/next")
	public CommandStatusBean next(@QueryParam("server") String serverName){
		return util.getNextCommandStatus(serverName);
	}
	
	


}
