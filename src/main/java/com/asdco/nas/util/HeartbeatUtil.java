package com.asdco.nas.util;

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
		logHeartbeat(serverId, visibleAddress);

		return "OK server " + serverId + " at " + visibleAddress + ". No commands";
	}

	private void logHeartbeat(String serverId, String visibleAddress) {
		//create a new heartbeat log entry
		HeartbeatLog entry = new HeartbeatLog();

		//add the server id that was provided by the client in the GET request path
		entry.setServerId(serverId);

		//add the address that the request came from
		entry.setVisibleIP(visibleAddress);

		//save it to the database
		jpaUtil.persist(entry);
	}
}
