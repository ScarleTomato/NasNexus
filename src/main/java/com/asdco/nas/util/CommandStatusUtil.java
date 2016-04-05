package com.asdco.nas.util;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import static java.lang.Math.toIntExact;

import javax.inject.Inject;

import com.asdco.nas.dao.CommandStatus;
import com.asdco.nas.dao.NasServer;
import com.asdco.nas.dao.ServerCommand;
import com.asdco.nas.dto.CommandStatusBean;

public class CommandStatusUtil {

	@Inject
	JpaUtil jpaUtil;

	@Inject
	NasServerUtil nasServerUtil;

	@Inject
	ServerCommandUtil serverCommandUtil;

	@Inject
	CommandStatusBean CommandStatusResponse;

	public String registerCommandStatus(CommandStatus commandToRegister) {
		jpaUtil.persist(commandToRegister);
		return "Your wish is my command";
	}

	public List<CommandStatus> getCommandList(Long ServerId) {
		List<CommandStatus> commandList;
		HashMap<String, Object> commandsForServer = new HashMap<String, Object>();
		commandsForServer.put("ServerId", ServerId);
		commandList = jpaUtil.executeGetNamedQuery("CommandStatus.findByNasServerId", commandsForServer,
				CommandStatus.class);
		CommandStatus oldCmd = commandList.get(0);
		Calendar timeStamp = new GregorianCalendar();
		oldCmd.setServerRetrievedCmd(timeStamp);
		jpaUtil.merge(oldCmd);
		return commandList;
	}

	public long getNumberOfCommands(Long serverId) {
		List<CommandStatus> list = getCommandList(serverId);
		return list.size();
	}

	public String addCommand(String server, String commandName) {
		NasServer affectedServer = nasServerUtil.getServerByName(server);
		ServerCommand command = serverCommandUtil.getCommandByName(commandName);
		CommandStatus newCommand = new CommandStatus();
		newCommand.setServerCommand(command);
		//newCommand.setCmdId(command.getId());
		Calendar calendar = new GregorianCalendar();
		newCommand.setCmdCreationDate(calendar);
		newCommand.setNasServerId(affectedServer.getId());
		return registerCommandStatus(newCommand);
	}

//	public String getNextSet(String serverName){
//		String[] cmdSet = new String[2]; 
//		cmdSet[0]=String.valueOf(getNextCommandId(serverName));
//		cmdSet[1]=String.valueOf(getNextCommand(serverName));
//		 String data = cmdSet[0]+","+cmdSet[1];
//		 return data;
//	}
	
//	public Long getNextCommand(String serverName) {
//		NasServer affectedServer = nasServerUtil.getServerByName(serverName);
//		Long serverId = affectedServer.getId();
//		List<CommandStatus> listOfCommands = getCommandList(serverId);
//		if (listOfCommands.size() != 0) {
//			CommandStatus nextCommand = listOfCommands.get(0);
//			return nextCommand.getCmdId();
//		} else {
//			return null;
//		}
//
//	}
//

	public CommandStatusBean getNextCommandStatus(String serverName) {
		NasServer affectedServer = nasServerUtil.getServerByName(serverName);
		List<CommandStatus> listOfCommands = getCommandList(affectedServer.getId());
		if (listOfCommands.size() != 0) {
			CommandStatus nextCommand = listOfCommands.get(0);
			CommandStatusBean b = buildCommandStatusBean(nextCommand);
			return b;
		}else{
		return null;
		}
	}

	public CommandStatusBean buildCommandStatusBean(CommandStatus c) {
		CommandStatusBean b = new CommandStatusBean();
		b.setId(c.getId());
		b.setNasServerId(c.getNasServerId());
		b.setCmdCreationDate(c.getCmdCreationDate());
		ServerCommand rootCmd = c.getServerCommand();
		b.setCmdId(rootCmd.getId());
		
		return b;
	}

}
