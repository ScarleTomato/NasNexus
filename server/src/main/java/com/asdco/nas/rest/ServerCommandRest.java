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

import com.asdco.nas.dao.ServerCommand;
import com.asdco.nas.util.ServerCommandUtil;

@Path(value = "/Master")
public class ServerCommandRest {

	@Inject
	ServerCommandUtil util;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addMaster")
	public String addMasterCommand(@QueryParam("name") String name) {
		ServerCommand newCommand = new ServerCommand();
		newCommand.setName(name);
		Calendar createdDate = new GregorianCalendar();
		newCommand.setLogDate(createdDate);
		return util.registerMasterCommand(newCommand);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/masterList")
	public List<ServerCommand> getMasterList() {
		return util.getMasterList();
	}


	@GET
	@Path("/addCommand/{server}/{command}")
	public String addCommandForServer(@PathParam("server") String server, @PathParam("command") String command) {

		int wasAdded = 0;
		if (wasAdded == 1) {
			return "The command " + command + " has been added for " + server + ".";
		} else {
			return "Opps. Something went wrong.";
		}
	}

}