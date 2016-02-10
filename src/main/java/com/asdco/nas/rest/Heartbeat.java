package com.asdco.nas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path(value = "/Heartbeat")
public class Heartbeat {

	@GET
	public String getProperties() {
		return "OK";
	}
}
