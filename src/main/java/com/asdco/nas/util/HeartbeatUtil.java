package com.asdco.nas.util;

import java.util.Calendar;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.asdco.nas.dao.HeartbeatLog;

@ApplicationScoped
public class HeartbeatUtil {

	@Inject
	JpaUtil jpaUtil;

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
		/**Get # of cmds for serverId as numOfCmds\
		 * First need to post cmds to the DB
		**/

		return "Message received for server " + serverId + " from " + visibleAddress + " on " + logDate.getTime() + ". Number of commands: ";
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
}
