package com.simple.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.simple.model.Account;
import com.simple.model.Song;

public class SongInfo {
	static String tableName = "songinfo";
	public static ArrayList findAll() {
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList list=new ArrayList();  
        String sql= String.format("select * from %s",tableName);
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
                Song obj=new Song();  
                //obj.setId(rs.getInt(1));
                obj.setSong_title(rs.getString(1));
                obj.setSong_singer(rs.getString(2));
                obj.setSong_len(rs.getString(3));
                obj.setSong_uper(rs.getString(4));
                obj.setSong_up_date(rs.getString(5));
                obj.setSong_click_num(rs.getInt(6));
                list.add(obj);
            } 
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{  
                BaseDao.close(rs, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return list;  
        }  
	}
	public static ArrayList findByKeys(String[]wheres, String[]keys) {
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList list=new ArrayList();  
        String sql=String.format("select * from %s where ",tableName);
        for(String where: wheres) {
        	sql = sql + where+"=? ";  
        }
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);
            for(int i = 0; i < keys.length;i++) {
            	psta.setString(i+1, keys[i]);
            }  
            rs=psta.executeQuery();  
            while(rs.next()){  
            	 Song obj=new Song();  
                 //obj.setId(rs.getInt(1));
                 obj.setSong_title(rs.getString(1));
                 obj.setSong_singer(rs.getString(2));
                 obj.setSong_len(rs.getString(3));
                 obj.setSong_uper(rs.getString(4));
                 obj.setSong_up_date(rs.getString(5));
                 obj.setSong_click_num(rs.getInt(6));
                 list.add(obj);
            } 
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{  
                BaseDao.close(rs, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return list;  
        }  
	}
	public static ArrayList findByKey(String where, String key) {
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList list=new ArrayList();  
        String sql=String.format("select * from %s where %s =?", tableName, where);
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);
            psta.setString(1, key);  
            rs=psta.executeQuery();  
            while(rs.next()){  
            	 Song obj=new Song();  
                 //obj.setId(rs.getInt(1));
                 obj.setSong_title(rs.getString(1));
                 obj.setSong_singer(rs.getString(2));
                 obj.setSong_len(rs.getString(3));
                 obj.setSong_uper(rs.getString(4));
                 obj.setSong_up_date(rs.getString(5));
                 obj.setSong_click_num(rs.getInt(6));
                 list.add(obj);
            } 
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{  
                BaseDao.close(rs, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return list;  
        }  
	}
	public static Song findAccountByKey(String where,String key) {
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        Song obj=null;  
        String sql=String.format("select * from %s where %s=?",tableName,where);  
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setString(1, key);
            rs=psta.executeQuery();  
            if(rs.next()){  
            	 obj=new Song();  
                 //obj.setId(rs.getInt(1));
                 obj.setSong_title(rs.getString(1));
                 obj.setSong_singer(rs.getString(2));
                 obj.setSong_len(rs.getString(3));
                 obj.setSong_uper(rs.getString(4));
                 obj.setSong_up_date(rs.getString(5));
                 obj.setSong_click_num(rs.getInt(6));
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{  
                BaseDao.close(rs, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return obj;  
        }  
	}
	public static Song findAccountByKeys(String[] wheres,String[] keys) {
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        Song obj=null;  
        String sql=String.format("select * from %s where ",tableName);
        for(String where: wheres) {
        	sql = sql + where+"=? ";  
        }
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);
            for(int i = 0; i < keys.length;i++) {
            	psta.setString(i+1, keys[i]);
            }
            rs=psta.executeQuery();  
            if(rs.next()){  
            	 obj=new Song();  
                 //obj.setId(rs.getInt(1));
                 obj.setSong_title(rs.getString(1));
                 obj.setSong_singer(rs.getString(2));
                 obj.setSong_len(rs.getString(3));
                 obj.setSong_uper(rs.getString(4));
                 obj.setSong_up_date(rs.getString(5));
                 obj.setSong_click_num(rs.getInt(6));
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{  
                BaseDao.close(rs, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return obj;  
        }  
	}
	/*public boolean update(Account obj){  
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql=String.format("update %s set act_pw=? where act_id=?",tableName);  
        boolean flag=false;  
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setString(1,obj.getActId());
            psta.setString(2,obj.getPw());  
            flag=psta.executeUpdate()>0;  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{  
                BaseDao.close(null, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return flag;  
        }  
    }*/
}
