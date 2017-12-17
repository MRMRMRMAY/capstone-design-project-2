package com.simple.jsonHandle;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;

public class SongJsonparse {
	public static HashMap<String, String> jsonparsing(String a) {
		HashMap<String, String> pushusertbl = new HashMap<String, String>();
		String clm1 = "song_title";
		String clm2 = "song_singer";
		String clm3 = "song_uper";
		String clm4 = "song_up_date";
		String clm5 = "song_length";
		String clm6 = "song_click_num";
		try {
			JsonFactory jfactory = new JsonFactory();
			org.codehaus.jackson.JsonParser jParser = jfactory.createJsonParser(a);
			while (jParser.nextToken() != JsonToken.END_OBJECT) {
				String fieldname = jParser.getCurrentName();
				if (clm1.equals(fieldname)) {
					jParser.nextToken();
					pushusertbl.put(clm1, jParser.getText());
//					 System.out.println(jParser.getText());
				}
				if (clm2.equals(fieldname)) {
					jParser.nextToken();
					pushusertbl.put(clm2, jParser.getText());
//					 System.out.println(jParser.getText());
				}
				if (clm3.equals(fieldname)){
					jParser.nextToken();
					pushusertbl.put(clm3, jParser.getText());
				}
				if (clm4.equals(fieldname)){
					jParser.nextToken();
					pushusertbl.put(clm4, jParser.getText());
				}
				if (clm5.equals(fieldname)){
					jParser.nextToken();
					pushusertbl.put(clm5, jParser.getText());
				}
				if (clm6.equals(fieldname)){
					jParser.nextToken();
					pushusertbl.put(clm6, jParser.getText());
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
