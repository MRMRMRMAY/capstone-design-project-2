package com.simple.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.model.Account;

public class AccountInfo {
	public static ArrayList findAll() {
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList list=new ArrayList();  
        String sql="select * from accountinfo";
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);  
            rs=psta.executeQuery();  
            while(rs.next()){  
                Account obj=new Account();  
                //obj.setId(rs.getInt(1));
                obj.setAct_Id(rs.getString(1));
                obj.setPw(rs.getString(2));
                obj.setFirst_name(rs.getString(3));
                obj.setLast_name(rs.getString(4));
                obj.setEmail_address(rs.getString(5));
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
        String sql="select * from accountinfo where ";
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
                Account obj=new Account();  
                //obj.setId(rs.getInt(1));
                obj.setAct_Id(rs.getString(1));
                obj.setPw(rs.getString(2));
                obj.setFirst_name(rs.getString(3));
                obj.setLast_name(rs.getString(4));
                obj.setEmail_address(rs.getString(5));
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
        String sql="select * from accountinfo where " + where + "=?";
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);
            psta.setString(1, key);  
            rs=psta.executeQuery();  
            while(rs.next()){  
                Account obj=new Account();  
                //obj.setId(rs.getInt(1));
                obj.setAct_Id(rs.getString(1));
                obj.setPw(rs.getString(2));
                obj.setFirst_name(rs.getString(3));
                obj.setLast_name(rs.getString(4));
                obj.setEmail_address(rs.getString(5));
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
	public static Account findAccountByKey(String where,String key) {
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        Account obj=null;  
        String sql="select * from accountinfo where "+where+"=?";  
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setString(1, key);
            rs=psta.executeQuery();  
            if(rs.next()){  
                obj=new Account();  
                obj.setAct_Id(rs.getString(1));  
                obj.setPw(rs.getString(2));   
                obj.setFirst_name(rs.getString(3));
                obj.setLast_name(rs.getString(4));
                obj.setEmail_address(rs.getString(5));
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
	public static Account findAccountByKeys(String[] wheres,String[] keys) {
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        Account obj=null;  
        String sql="select act_id, act_pw from accountinfo where ";
        for(int i = 0; i < wheres.length-1;i++) {
        	sql = sql + wheres[i]+"=? and ";  
        }
        sql = sql + wheres[wheres.length-1]+"=?";
        System.out.println(sql);
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);
            for(int i = 0; i < keys.length;i++) {
            	psta.setString(i+1, keys[i]);
            }
            rs=psta.executeQuery();  
            if(rs.next()){  
                obj=new Account();  
                //obj.setId(rs.getInt(1));  
                obj.setAct_Id(rs.getString(1));  
                obj.setPw(rs.getString(2));   
                //obj.setFirst_name(rs.getString(3));
                //obj.setLast_name(rs.getString(4));
                //obj.setEmail_address(rs.getString(5));
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
	public boolean update(Account obj){  
        Connection con=null;  
        PreparedStatement psta=null;  
        String sql="update accountinfo set act_pw=? where act_id=?";  
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
    }
	public static int addNewAccount(String act_id, String act_pw, String first_name, String last_name, String email_address) {
		// TODO Auto-generated method stub
		Connection con=null;
        PreparedStatement psta=null;  
        ResultSet rs=null;
		String sql = "INSERT INTO accountinfo (act_id,act_pw,first_name,last_name,email_address,status) VALUES(?,?,?,?,?)";
		boolean isFalse = true;
		try{
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);
            psta.setString(1, act_id);
    		psta.setString(2, act_pw);
    		psta.setString(3, first_name);
    		psta.setString(4, last_name);
    		psta.setString(5, email_address);
    		psta.setInt(6, 1);
    		isFalse=psta.execute(); 
    		System.out.println(isFalse);
        }catch(Exception e){  
            e.printStackTrace();
        }finally{  
            try{  
                BaseDao.close(rs, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }
            if(isFalse)
    			return -1;
    		return 0;
        }
	}
}
