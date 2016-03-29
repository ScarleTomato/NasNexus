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
		/**Get # of cmds for serverId as numOfCmds\
		 * First need to post cmds to the DB
		**/
		//return "Message received for server " + serverId + " from " + visibleAddress + " on " + logDate.getTime() + ". Number of commands: "+CommandStatusUtil.getNumberOfCommands(l);
		 return ""+CommandStatusUtil.getNumberOfCommands(l);
	}

	private Calendar logHeartbeat(String serverId, String visibleAddress) {
		//create a new heartbeat log entry
		HeartbeatLog entry = new HeartbeatLog();

		//add the server id that was provided by the client in the GET request e
		entry.setServerId(serverId);

		//add the address that the request came from
		entry.setVisibleIP(visibleAddress);

		//save it to the database
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
