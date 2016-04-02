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
import com.asdco.nas.dto.CommandStatusResponse;

public class CommandStatusUtil {

	@Inject
	JpaUtil jpaUtil;

	@Inject
	NasServerUtil nasServerUtil;

	@Inject
	ServerCommandUtil serverCommandUtil;

	@Inject
	CommandStatusResponse CommandStatusResponse;

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

	public long getNumberOfCommands(Long serverId) {
		List<CommandStatus> list = getCommandList(serverId);
		return list.size();
	}

	public String addCommand(String server, String commandName) {
		NasServer affectedServer = nasServerUtil.getServerByName(server);
		ServerCommand command = serverCommandUtil.getCommandByName(commandName);
		CommandStatus newCommand = new CommandStatus();
		newCommand.setCmdId(command.getId());
		Calendar calendar = new GregorianCalendar();
		newCommand.setCmdCreationDate(calendar);
		newCommand.setNasServerId(affectedServer.getId());
		return registerCommandStatus(newCommand);
	}

	public String getNextSet(String serverName){
		Long[] cmdSet = new Long[2]; 
		cmdSet[0]=getNextCommandId(serverName);
		cmdSet[1]=getNextCommand(serverName);
		return String.valueOf(cmdSet);
	}
	
	public Long getNextCommand(String serverName) {
		NasServer affectedServer = nasServerUtil.getServerByName(serverName);
		Long serverId = affectedServer.getId();
		List<CommandStatus> listOfCommands = getCommandList(serverId);
		if (listOfCommands.size() != 0) {
			CommandStatus nextCommand = listOfCommands.get(0);
			return nextCommand.getCmdId();
		} else {
			return null;
		}

	}
//Flag
	public Long getNextCommandId(String serverName) {
		NasServer affectedServer = nasServerUtil.getServerByName(serverName);
		Long serverId = affectedServer.getId();
		List<CommandStatus> listOfCommands = getCommandList(serverId);
		if (listOfCommands.size() != 0) {
			CommandStatus nextCommand = listOfCommands.get(0);
			return nextCommand.getId();
		} else {
			return null;
		}
	}

	public CommandStatusResponse buildBean(CommandStatus c) {
		CommandStatusResponse b = new CommandStatusResponse();
		b.setId(c.getId());
		b.setNasServerId(c.getNasServerId());
		b.setCmdId(c.getCmdId());
		b.setCmdIsDone(c.getCmdIsDone());
		b.setCmdCreationDate(c.getCmdCreationDate());
		b.setServerRetrievedCmd(c.getServerRetrievedCmd());
		b.setServerCompleatedCmd(c.getServerCompleatedCmd());

		return b;
	}

}
