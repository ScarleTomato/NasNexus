package com.asdco.nas.util;

import java.util.Calendar; 

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import com.asdco.nas.dao.CommandStatus;
import com.asdco.nas.dao.HeartbeatLog;
import com.asdco.nas.dto.HeartbeatResponse;

@ApplicationScoped
public class HeartbeatUtil {

	@Inject
	JpaUtil jpaUtil;
	@Inject
	CommandStatusUtil CommandStatusUtil;

	/**
	 * Receive a heart beat from a NAS server and let the server know if there
	 * are any queued commands
	 * 
	 * @param serverId
	 * @param visibleAddress
	 * @return a command
	 */

	public String receiveHeartbeat(String serverId, String visibleAddress) {
		Calendar logDate = logHeartbeat(serverId, visibleAddress);
		 long l = Long.parseLong(serverId);
		 return ""+CommandStatusUtil.getNumberOfCommands(l);
	}

	private Calendar logHeartbeat(String serverId, String visibleAddress) {
		HeartbeatLog entry = new HeartbeatLog();
		entry.setServerId(serverId);
		entry.setVisibleIP(visibleAddress);
		jpaUtil.persist(entry);
		
		return entry.getLogDate();
	}
	
	public HeartbeatResponse buildBean(HeartbeatLog c){
		HeartbeatResponse b = new HeartbeatResponse();
		b.setId(c.getId());
		b.setLogDate(c.getLogDate());
		
		return b;
	}
}
