package com.simple.restws;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("fileup")
public class FileupHandle {
@POST
@Path("/music")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public void postFile(@FormParam("filename")String filename) {
		System.out.println("FileupHandle:"+filename);
	}
}
