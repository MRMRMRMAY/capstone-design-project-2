package com.simple.jsonHandle;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;

public class RegisterJsonparse {
	public static HashMap<String, String> jsonparsing(String a) {
		HashMap<String, String> pushusertbl = new HashMap<String, String>();
		try {
			JsonFactory jfactory = new JsonFactory();
			org.codehaus.jackson.JsonParser jParser = jfactory.createJsonParser(a);
			while (jParser.nextToken() != JsonToken.END_OBJECT) {
				String fieldname = jParser.getCurrentName();
				if ("act_id".equals(fieldname)) {
					jParser.nextToken();
					pushusertbl.put("act_id", jParser.getText());
//					 System.out.println(jParser.getText());
				}
				if ("act_pw".equals(fieldname)) {
					jParser.nextToken();
					pushusertbl.put("act_pw", jParser.getText());
//					 System.out.println(jParser.getText());
				}
				if ("first_name".equals(fieldname)){
					jParser.nextToken();
					pushusertbl.put("first_name", jParser.getText());
				}
				if ("last_name".equals(fieldname)){
					jParser.nextToken();
					pushusertbl.put("last_name", jParser.getText());
				}
				if ("email_address".equals(fieldname)){
					jParser.nextToken();
					pushusertbl.put("email_address", jParser.getText());
				}
			}
			jParser.close();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pushusertbl;
	}
}
