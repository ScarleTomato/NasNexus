package com.asdco.nas.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return commandList;
	}
	public CommandStatus getSingleCommand(Long id){
		return jpaUtil.executeGetSingleResult("CommandStatus.findById", CommandStatus.class, "id",id);
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
		Calendar calendar = new GregorianCalendar();
		newCommand.setCmdCreationDate(calendar);
		newCommand.setNasServerId(affectedServer.getId());
		return registerCommandStatus(newCommand);
	}

	public CommandStatusBean getNextCommandStatus(String serverName) {
		NasServer affectedServer = nasServerUtil.getServerByName(serverName);
		List<CommandStatus> listOfCommands = getCommandList(affectedServer.getId());
		CommandStatus oldCmd = listOfCommands.get(0);
		Calendar timeStamp = new GregorianCalendar();
		oldCmd.setServerRetrievedCmd(timeStamp);
		jpaUtil.merge(oldCmd);
		if (listOfCommands.size() != 0) {
			CommandStatus nextCommand = listOfCommands.get(0);
			CommandStatusBean b = buildCommandStatusBean(nextCommand);
			return b;
		} else {
			return null;
		}
	}

	public CommandStatusBean updateCommandStatus(Long commandStatusId, String serverName) {
		NasServer affectedServer = nasServerUtil.getServerByName(serverName);
		List<CommandStatus> listOfCommands = getCommandList(affectedServer.getId());
		CommandStatus oldCmd = listOfCommands.get(0);
		oldCmd.setCmdIsDone(1);
		Calendar timeStamp = new GregorianCalendar();
		oldCmd.setServerCompleatedCmd(timeStamp);
		jpaUtil.merge(oldCmd);
		return getNextCommandStatus(serverName);
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
