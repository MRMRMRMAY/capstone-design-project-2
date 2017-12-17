package com.simple.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class BaseDao {
	private static JdbcPool pool = new JdbcPool();
	public static Connection getConnection(){
        return pool.getConnection();
    }  
    
    public static void close(ResultSet rs,Statement sta,Connection con)throws Exception{  
        if(rs!=null){  
                 //关闭结果集  
                rs.close();  
        }  
        if(sta!=null){  
                 //关闭操作句柄  
                 sta.close();  
        }  
        if(con!=null){  
                //关闭链接  
                con.close();  
        }  
    }
}
