package com.asdco.nas.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.asdco.nas.dao.HeartbeatLog;
import com.asdco.nas.dao.NasServer;
import com.asdco.nas.dto.HeartbeatBean;

@ApplicationScoped
public class HeartbeatUtil {

	@Inject
	JpaUtil jpaUtil;
	@Inject
	CommandStatusUtil CommandStatusUtil;
	@Inject
	NasServerUtil nasServerUtil;

	public HeartbeatBean receiveHeartbeat(String name, String visibleAddress) {
		NasServer server = nasServerUtil.getServerByName(name);
		Long serverId = server.getId();
		HeartbeatBean bean = logHeartbeat(serverId, visibleAddress);
		bean.setNumOfCommands(CommandStatusUtil.getNumberOfCommands(serverId));
		return bean;
	}

	private HeartbeatBean logHeartbeat(Long serverId, String visibleAddress) {
		HeartbeatLog entry = new HeartbeatLog();
		entry.setServerId(serverId);
		entry.setVisibleIP(visibleAddress);
		jpaUtil.persist(entry);
		HeartbeatBean bean = buildBean(entry);
		return bean;
	}

	public static HeartbeatBean buildBean(HeartbeatLog c) {
		HeartbeatBean b = new HeartbeatBean();
		b.setId(c.getId());
		b.setLogDate(c.getLogDate());
		b.setServerId(c.getServerId());
		b.setVisibleIP(c.getVisibleIP());

		return b;
	}
}
