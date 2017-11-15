package com.simple.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.simple.model.Account;

public class AccountInfo {
	public ArrayList findAll() {
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
                obj.setId(rs.getInt(1));
                obj.setAct_Id(rs.getString(2));
                obj.setPw(rs.getString(3));
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
	public Account findAccountByActId(String _act_id) {
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        Account obj=null;  
        String sql="select * from accountinfo where act_id=?";  
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setString(1, _act_id);  
            rs=psta.executeQuery();  
            if(rs.next()){  
                obj=new Account();  
                obj.setId(rs.getInt(1));  
                obj.setAct_Id(rs.getString(2));  
                obj.setPw(rs.getString(3));   
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
}
