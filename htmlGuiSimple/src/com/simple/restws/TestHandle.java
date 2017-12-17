package com.simple.restws;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.simple.DAO.SongInfo;
import com.simple.model.Song;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Path("test")
public class TestHandle {
	@GET
	@Path("/data")
	public String testPost(String info, @Context HttpServletRequest request) {
		List<Song> result = new ArrayList();
		for(int i = 0; i <= 10; i++) {
			Song temp = new Song();
			temp.setSong_id(i);
			temp.setSong_title("Song "+i);
			temp.setSong_singer("singer "+i);
			temp.setSong_len("3:0"+i);
			temp.setSong_up_date(String.format("2017-12-%02d",i));
			temp.setSong_uper("uper "+i);
			temp.setSong_click_num(1000+i);
			result.add(temp);
		}
		int count = result.size();
		JSONArray jsonList = new JSONArray();
		for(Song temp : result) {
			JSONObject tempJson = JSONObject.fromObject(temp);
			jsonList.add(tempJson);
		}
		JSONObject json = new JSONObject();
		json.put("total", count);
		json.put("data", jsonList);
		System.out.println(json);
		return json.toString();
	}
}
