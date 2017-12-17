package com.simple.restws;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.simple.jsonHandle.jsonparse;

import net.sf.json.JSONObject;

@Path("hello")
public class HelloResource {  

	@GET
	@Path("/getSayHello")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayhello(String info, @Context HttpServletRequest request){
		System.out.println("success");
		return "get hello jersey.";
	}
	
	@POST
	@Path("/postSayHello")
	public Response  sayhelloPost(String info, @Context HttpServletRequest request)
			throws SQLException, IOException, PropertyVetoException {
		System.out.println(info);
		String name = jsonparse.jsonparsing(info).get("name");
		return Response.ok().status(200).build();
	}
	@PUT
	@Path("/putSayHello")
	public String sayHelloPut(@QueryParam("name") String name){
		return name + " put say hello.";
	}
}  