package com.simple.restws;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.simple.DAO.SongInfo;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;


@Path("fileup")
public class FileupHandle {
@POST
@Path("/music")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response postFile(
		@FormDataParam("filename") String filename,
		@FormDataParam("username") String upername,
		@FormDataParam("songname") String songname,
		@FormDataParam("file") InputStream uploadedInputStream,
		@FormDataParam("file") FormDataContentDisposition fileDetail) {
//public Response postFile(String info, @Context HttpServletRequest request) {
		System.out.println("FileupHandle: ok" +fileDetail);
		if(fileDetail==null) {
			System.out.println("FileupDetail: error" );
			return Response.status(400).build();
		}
		else
			System.out.println("FileupDetail: ok"+fileDetail.getFileName());
		if(SongInfo.findCountByKye(songname, upername)>0) {
			System.out.println("existing error");
			return Response.status(400).entity("song already exists").build();
		}
		//return Response.status(200).entity("file ok").build();
		String suf = fileDetail.getFileName().split("\\.")[1];
		String saveFilename = songname +"."+ suf;
		System.out.println(saveFilename);
		String uploadedFileLocation="F:\\2017 2\\cdp\\capstone-design-project-2\\javaPro\\dianoRestWeb\\src\\music\\"+saveFilename;
		if(SongInfo.addNewSong(songname, upername, uploadedFileLocation)==-1) {
			return Response.status(400).entity("failues").build();
		}
		writeTofile(uploadedInputStream, uploadedFileLocation);
		//String output = "File uploaded to :" +uploadedFileLocation;
		String output="upload succeeded";
		return Response.status(200).entity(output).build();
	}
	private void writeTofile(InputStream uploadedInputStream, 
							String uploadedFileLocation) {
		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];
			out = new FileOutputStream(new File(uploadedFileLocation));
			while((read = uploadedInputStream.read(bytes))!=-1) {
				out.write(bytes,0,read);
			}
			out.flush();
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
