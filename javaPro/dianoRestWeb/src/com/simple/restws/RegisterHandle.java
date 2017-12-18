package com.simple.restws;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.simple.DAO.AccountInfo;
import com.simple.jsonHandle.RegisterJsonparse;
import com.simple.model.Account;

@Path("register")
public class RegisterHandle {
	@POST
	@Path("/postRegister")
	public Response registerPost(String info, @Context HttpServletRequest request) {
		Map<String,String> infoMap = RegisterJsonparse.jsonparsing(info);
		Account foundByActId = AccountInfo.findAccountByKey("act_id",infoMap.get("act_id"));
		Account foundByEmailAddress = AccountInfo.findAccountByKey("email_address",infoMap.get("email_address"));
		System.out.println("he");
		if(foundByActId == null && foundByEmailAddress == null)
		{
			if(AccountInfo.addNewAccount(
					infoMap.get("act_id"),infoMap.get("act_pw"),infoMap.get("first_name"),
					infoMap.get("last_name"),infoMap.get("email_address")) == -1) {
				System.out.println("a");
				return Response.ok().status(400).entity("error").build();
			}
			else {
				System.out.println("b");
				return Response.ok().status(200).entity("ok").build();
			}
		}else if(foundByActId != null){
			System.out.println("c");
			return Response.ok().status(400).entity("This id has already been used").build();
		}else {
			System.out.println("d");
			return Response.ok().status(400).entity("This email address has already been used").build();
		}
	}
}
