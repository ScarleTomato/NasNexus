package com.asdco.nas.util;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import com.asdco.nas.dao.NasServer;

public class NasServerUtil {

	@Inject
	JpaUtil jpaUtil;

	public String registerServer(NasServer serverToRegister) {
		jpaUtil.persist(serverToRegister);
		return "Your server id is " + serverToRegister.getId();
	}

	public NasServer getServerByName(String name) {
		System.out.println(name);
		List<NasServer> serverList;
		HashMap<String, Object> requestedName = new HashMap<String, Object>();
		requestedName.put("name", name);
		serverList = jpaUtil.executeGetNamedQuery("NasServer.findByName", requestedName, NasServer.class);
		return serverList.get(0);
	}

	public String addServer(String name) {
		NasServer entry = new NasServer();
		return (registerServer(entry));
	}

	public List<NasServer> getAllServers() {
		return jpaUtil.executeGetNamedQuery("NasServer.findAll", null, NasServer.class);
	}

}
