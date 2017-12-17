package com.simple.restws;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.simple.DAO.SongInfo;

@Path("download")
public class FileDownloadRequestHandle {
	@GET
	@Path("/piano/{id}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getPianoMusicFile(@PathParam("id") String info, @Context HttpServletRequest request) throws IOException{
		String filepath = SongInfo.findPathById(info);
		if(filepath == null || filepath == "") {
			return Response.ok().status(400).entity("ERROR").build();
		}
		File file = new File(filepath);
		//File file = new File("F:\\2017 2\\cdp\\capstone-design-project-2\\javaPro\\dianoRestWeb\\src\\music\\"+info);
		System.out.println(info);
		System.out.println(file.getAbsolutePath());
		ResponseBuilder responseBuilder = Response.ok(file);
		responseBuilder.type("application/x-msdownload");
		responseBuilder.header("Content-Disposition", "attachment;filename=\""
				+ file.getName()+"\"");
		Response response = responseBuilder.build();
		return response;
	}
}
