package com.asdco.nas.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import com.asdco.nas.dao.CommandStatus;
import com.asdco.nas.dao.NasServer;
import com.asdco.nas.dao.ServerCommand;


public class CommandStatusUtil {


	@Inject
	JpaUtil jpaUtil;
	
	@Inject
	NasServerUtil nasServerUtil;
	
	@Inject
	ServerCommandUtil serverCommandUtil;
	
	public String registerCommandStatus(CommandStatus commandToRegister){
		jpaUtil.persist(commandToRegister);
		return "Your wish is my command";
	}

	public List getCommandList(Long ServerId){
		List<CommandStatus> commandList;
		HashMap<String,Object> commandsForServer = new HashMap<String,Object>();
		commandsForServer.put("ServerId", ServerId);
		commandList = jpaUtil.executeGetNamedQuery("CommandStatus.findByNasServerId", commandsForServer, CommandStatus.class);
		return commandList;
	}
		
	public String addCommand(String server,String commandName){
	//objects needed, NasServer, CmdId
	NasServer affectedServer = nasServerUtil.getServerByName(server); 
	ServerCommand command = serverCommandUtil.getCommandByName(commandName);
	CommandStatus newCommand = new CommandStatus();
	newCommand.setCmdId(command.getId());
	Calendar calendar = new GregorianCalendar();
	newCommand.setCmdCreationDate(calendar);
	newCommand.setNasServerId(affectedServer.getId());
	//persist the cmd to CommandStatus
		return registerCommandStatus(newCommand);
}
	public String getNextCommand(String serverName){
		NasServer affectedServer = nasServerUtil.getServerByName(serverName);
		Long serverId = affectedServer.getId();
		List <CommandStatus> listOfCommands = getCommandList(serverId);
		CommandStatus nextCommand = listOfCommands.get(0);
		return "next commands is: "+nextCommand+".";
		
	}
	
	

}
