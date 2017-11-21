package com.simple.restws;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.simple.jsonHandle.jsonparse;

@Path("search")
public class SearchHandle {
	@GET
	@Path("/piano")
	public Response pSrchR(String info, @Context HttpServletRequest request){
		Map<String,String> map = jsonparse.jsonparsing(info);
		String key = map.get("srch_key");
		String val = map.get("srch_val");
		
		if(true)
			return Response.ok().status(200).build();
		else
			return Response.ok().status(400).build();
	}
	
}
