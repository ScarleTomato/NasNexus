package com.asdco.nas.util;

import javax.inject.Inject;

import com.asdco.nas.dao.NasServer;

/**
 * 
 *This util class will call cmds for a given server.
 *
 * Need to create a called cmd Log.
 * --
 *
**/
public class ServerCommandsUtil{
	
	@Inject
	JpaUtil jpautil;
/**
	 * Adds a cmd to the dbo.ServerCmdStat for nasServer 
	 * use getCmdNameById **TBC
	 * 
	 **/
	public String addCommandFor(NasServer server){
		
		
		
		return "Hello World";
		
	}
}