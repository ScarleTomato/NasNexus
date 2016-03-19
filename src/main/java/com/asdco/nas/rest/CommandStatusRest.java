package com.asdco.nas.rest;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
	JpaUtil jpaUtil;

	@Inject
	NasServerUtil nasServerUtil;
	
	@Inject
	ServerCommandUtil serverCommandUtil;
	/**
	 * new cmd for server
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
		//objects needed, NasServer, CmdId
		NasServer affectedServer = nasServerUtil.getServerByName(server); 
		ServerCommand command = serverCommandUtil.getCommandByName(commandName);
		CommandStatus newCommand = new CommandStatus();
		newCommand.setCmdId(command.getId());
		Calendar calendar = new GregorianCalendar();
		newCommand.setCmdCreationDate(calendar);
		newCommand.setNasServerId(affectedServer.getId());
		//persist the cmd to CommandStatus
			return util.registerCommandStatus(newCommand);
		//return "Hello World"+affectedServer.getName()+","+command.getName();
	}
	//get cmd list (all) for server
	//get cmd list (active) for server
	//get cmd list (done) for server
	//get list of servers with cmds / where cmdIsDone == 0

}
