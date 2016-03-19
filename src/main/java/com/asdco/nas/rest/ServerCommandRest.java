package com.asdco.nas.rest;

import javax.inject.Inject; 
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.asdco.nas.dao.ServerCommand;
import com.asdco.nas.util.JpaUtil;
import com.asdco.nas.util.NasServerUtil;
import com.asdco.nas.util.ServerCommandUtil;


@Path(value = "/Master")
public class ServerCommandRest{
	/**
	 * 
	 * list off commands
	 * -add master
	 * **add cmd name
	 * -get master cmd list
	 * -get master cmd creation timestamp by name
	 * 
	 * -add cmd for server
	 * **add to ServerCommandStatus
	 * **-numerate cmds for server: how many more cmds does server have in ServerCommandStatus
	 * execute cmd for server
	 * 
	 * 
	 **/
	@Inject
	ServerCommandUtil util;
	
	//add Master by name 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addMaster")
	public String addMasterCommand(@QueryParam("name") String name){
		ServerCommand newCommand = new ServerCommand();
		newCommand.setName(name);
		Calendar createdDate = new GregorianCalendar();
		newCommand.setLogDate(createdDate);
		return util.registerMasterCommand(newCommand);
		
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/masterList")
	public List<ServerCommand> getMasterList(){
		return util.getMasterList();
	}
	//add command for server
	/**
	 * 
	 * @param Adds command "command" for server "server" where String server is the Id
	 * @return Positive if the command was added 
	 */
	@GET @Path("/addCommand/{server}/{command}")
	public String addCommandForServer(@PathParam("server") String server,@PathParam("command") String command){
		
		int wasAdded = 0; 
				//addCommand(getCommandIdByName(command),server);
		//call add command,getCmdIdByName,Add cmd to status table for server by cmdId
		
		
		
		if(wasAdded==1){
				return"The command "+command+" has been added for "+server+".";
		}
		else{
			return"Opps. Something went wrong.";
		}
	}
	
	
	
}