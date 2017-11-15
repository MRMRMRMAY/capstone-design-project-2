package com.simple.restws;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.simple.DAO.AccountInfo;
import com.simple.jsonHandle.jsonparse;
import com.simple.model.Account;
@Path("login")
public class LoginResource {
	@POST
	@Path("/postLogin")
	public Response loginPost(String info, @Context HttpServletRequest request)
			throws SQLException, IOException, PropertyVetoException{
		System.out.println(info);
		String idString = jsonparse.jsonparsing(info).get("id");
		String pwString = jsonparse.jsonparsing(info).get("pw");
		//AccountInfo actInfo = new AccountInfo();
		//Account account = actInfo.findAccountByActId(idString);
		Account account = new Account("root","1q2w");
		if(pwString.equals(account.getPw())&&idString.equals(account.getActId())) {
			System.out.print("The account is ok");
			HttpSession session = request.getSession();
			session.setAttribute("act_id", account.getActId());
			return Response.ok().status(200).build();
		}else {
			System.out.print("The pw is error");
			return Response.ok().status(400).build();
		}
	}
}
