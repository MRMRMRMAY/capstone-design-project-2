package com.simple.restws;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
	@Path("/song")
	@Produces("application/json")
	public Response pSrchR(String info, @Context HttpServletRequest request){
		Map<String,String> map = jsonparse.jsonparsing(info);
		String key = map.get("srch_key");
		String val = map.get("srch_val");
		List<Song> result = SongInfo.findByKey(key, val);
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
		return Response.ok(json).status(200).build();
	}
	
}
