package com.simple.restws;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

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
public class LoginHandle{
	@POST
	@Path("/postLogin")
	public Response loginPost(String info, @Context HttpServletRequest request)
			throws SQLException, IOException, PropertyVetoException{
		System.out.println(info);
		Map<String,String> infoMap = jsonparse.jsonparsing(info);
		String idString = infoMap.get("id");
		String pwString = infoMap.get("pw");
		AccountInfo actInfo = new AccountInfo();
		Account account = actInfo.findAccountByKeys(new String[]{"act_id","act_pw"},new String[]{idString,pwString});
		//Account account = new Account("root","1q2w");
		if(account == null) {
			System.out.print("The account or pw is incorrect");
			return Response.ok("your account id or password is incorrect").status(Response.Status.BAD_REQUEST).build();
		}else {
			System.out.print("The account is ok");
			HttpSession session = request.getSession();
			session.setAttribute("act_id", account.getActId());
			Response.status(400).entity(null);
			
			return Response.ok().status(Response.Status.OK).build();
		}
	}
	
}
