package com.asdco.nas.util;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import com.asdco.nas.dao.ServerCommand;

public class ServerCommandUtil {

	@Inject
	JpaUtil jpaUtil;

	public ServerCommand getCommandByName(String name) {
		List<ServerCommand> commandList;
		HashMap<String, Object> requestedName = new HashMap<String, Object>();
		requestedName.put("name", name);
		commandList = jpaUtil.executeGetNamedQuery("ServerCommand.findByName", requestedName, ServerCommand.class);
		return commandList.get(0);
	}

	public String registerMasterCommand(ServerCommand commandToRegister) {
		jpaUtil.persist(commandToRegister);
		return "Master Command id is " + commandToRegister.getId();
	}

	public List<ServerCommand> getMasterList() {
		return jpaUtil.executeGetNamedQuery("ServerCommand.findAll", null, ServerCommand.class);
	}

}
