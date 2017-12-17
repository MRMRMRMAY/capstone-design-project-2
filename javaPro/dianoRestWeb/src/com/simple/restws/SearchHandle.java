package com.simple.restws;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;


import com.simple.DAO.SongInfo;
import com.simple.jsonHandle.jsonparse;
import com.simple.model.Song;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Path("search")
public class SearchHandle {
	@GET
	@Path("/song/{id}")
	public String pSrchR(@PathParam("id") String info, @Context HttpServletRequest request)  throws IOException {
//		Map<String,String> map = jsonparse.jsonparsing(info);
//		String val = map.get("srch_val");
		List<Song> result = SongInfo.findByKey(info);
		int count = result.size();
		JSONArray jsonList = new JSONArray();
		for(Song temp : result) {
			JSONObject tempJson = JSONObject.fromObject(temp);
			jsonList.add(tempJson);
		}
		JSONObject json = new JSONObject();
		json.put("count", count);
		json.put("data", jsonList);
		//json.toString();
		//return Response.ok().status(200).entity(json.toString()).build();
		return json.toString();
	}
	@GET
	@Path("/mysong/{id}")
	public String pSrchMySongR(@PathParam("id") String info,@Context HttpServletRequest request) throws IOException {
		List<Song> result = SongInfo.findSongByUper(info);
		int count = result.size();
		JSONArray jsonList = new JSONArray();
		for(Song temp : result) {
			JSONObject tempJson = JSONObject.fromObject(temp);
			jsonList.add(tempJson);
		}
		JSONObject json = new JSONObject();
		System.out.println(json.toString());
		json.put("count", count);
		json.put("data", jsonList);
		//json.toString();
		//return Response.ok().status(200).entity(json.toString()).build();
		return json.toString();
	}
	@POST
	@Path("/delect/{id}")
	public Response delectSong(@PathParam("id") String info,@Context HttpServletRequest request) throws IOException {
		int result = SongInfo.updateStatusById(Integer.parseInt(info));
		if(result==-1) {
			return Response.ok().status(400).entity("error").build();
		}
		else
			return Response.ok().status(200).entity("delected").build();
	}
}
