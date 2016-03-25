package com.asdco.nas.rest;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.asdco.nas.dao.CommandStatus;
import com.asdco.nas.dao.NasServer;
import com.asdco.nas.dao.ServerCommand;
import com.asdco.nas.util.CommandStatusUtil;
import com.asdco.nas.util.JpaUtil;
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
	/**
	 * add cmd for server
	 * get cmd list (all) for server
	 * get cmd list (active) for server
	 * get cmd list (done) for server
	 * get list of servers with cmds / where cmdIsDone == 0
	 */
	
	//new cmd for server
	// where name is the name of the server and id is the ServerCommandId
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String addCommand(@QueryParam("server") String server,@QueryParam("command") String commandName){
			return util.addCommand(server, commandName); 
	}
	//get cmd list (all) for server
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List getCommands(@QueryParam("serverId") Long serverId){
		return util.getCommandList(serverId);
	}
	//next cmd 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/next")
	public String next(@QueryParam("server") String serverName){
		return util.getNextCommand(serverName);
	}
	//cmd compleat
	
	//get cmd list (active) for server
	//get cmd list (done) for server
	//get list of servers with cmds / where cmdIsDone == 0
	
	//Get next command.
	
	

}
