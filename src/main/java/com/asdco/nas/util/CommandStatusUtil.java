package com.asdco.nas.util;

import javax.inject.Inject;

import com.asdco.nas.dao.CommandStatus;


public class CommandStatusUtil {


	@Inject
	JpaUtil jpaUtil;
	public String registerCommandStatus(CommandStatus commandToRegister){
		jpaUtil.persist(commandToRegister);
		return "Your wish is my command";
	}
		
	
	

}
