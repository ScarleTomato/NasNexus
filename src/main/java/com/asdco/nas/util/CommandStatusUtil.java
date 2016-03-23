package com.asdco.nas.util;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import com.asdco.nas.dao.CommandStatus;


public class CommandStatusUtil {


	@Inject
	JpaUtil jpaUtil;
	public String registerCommandStatus(CommandStatus commandToRegister){
		jpaUtil.persist(commandToRegister);
		return "Your wish is my command";
	}

	public List getCommandList(Long ServerName){
		List<CommandStatus> commandList;
		HashMap<String,Object> commandsForServer = new HashMap<String,Object>();
		commandsForServer.put("ServerId", ServerName);
		commandList = jpaUtil.executeGetNamedQuery("CommandStatus.findByNasServerId", commandsForServer, CommandStatus.class);
		return commandList;
	}
		
	
	

}
