package com.asdco.nas.util;

import java.lang.reflect.Array; 
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import com.asdco.nas.dao.CommandStatus;
import com.asdco.nas.dao.HeartbeatLog;
import com.asdco.nas.dao.NasServer;
import com.asdco.nas.dto.HeartbeatResponse;

@ApplicationScoped
public class HeartbeatUtil {

	@Inject
	JpaUtil jpaUtil;
	@Inject
	 //changed to static to allow 
	CommandStatusUtil CommandStatusUtil;
	@Inject
	NasServerUtil nasServerUtil;

	/**
	 * Receive a heart beat from a NAS server and let the server know if there
	 * are any queued commands
	 * 
	 * @param serverId
	 * @param visibleAddress
	 * @return a command
	 */

	public HeartbeatResponse receiveHeartbeat(String name, String visibleAddress) {
		NasServer server = nasServerUtil.getServerByName(name);
		Long serverId = server.getId();
		HeartbeatResponse bean = logHeartbeat(serverId, visibleAddress);
		 bean.setNumOfCommands(CommandStatusUtil.getNumberOfCommands(serverId));
		 return bean;
	}

	private HeartbeatResponse logHeartbeat(Long serverId, String visibleAddress) {
		HeartbeatLog entry = new HeartbeatLog();
		entry.setServerId(serverId);
		entry.setVisibleIP(visibleAddress);
		jpaUtil.persist(entry);
		HeartbeatResponse bean = buildBean(entry);
		return bean;
	}
	
	public static HeartbeatResponse buildBean(HeartbeatLog c){
		HeartbeatResponse b = new HeartbeatResponse();
		b.setId(c.getId());
		b.setLogDate(c.getLogDate());
		b.setServerId(c.getServerId());
		b.setVisibleIP(c.getVisibleIP());
		

		
		return b;
	}
}
