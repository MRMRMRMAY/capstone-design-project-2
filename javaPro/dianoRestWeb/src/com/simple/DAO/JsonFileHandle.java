package com.simple.DAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;
public class JsonFileHandle {
	String fPath = null;
	public JsonFileHandle(String _fName) {
		fPath = String.format("%s.json",_fName);
	}
	public boolean WriteFIle(String _content) {
		try {
			FileWriter fw = new FileWriter(fPath);
			PrintWriter out = new PrintWriter(fw);
			out.write(_content);
			fw.close();
			out.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			//do something
		}
		return true;
	}
	public String ReadFile() {
		File file = new File(fPath);
		BufferedReader reader = null;
		String str = "";
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while((tempString = reader.readLine()) != null) {
				str = str + tempString;
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			if(reader != null) {
				try {
					reader.close();
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return str;
	}
}
