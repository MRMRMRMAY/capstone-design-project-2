package com.simple.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	public static ArrayList findByKeys(String[]wheres, String[]key) {
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList list=new ArrayList();  
        String sql=String.format("select id, title, uper from %s where ",tableName);
        for(int i = 0; i < wheres.length-1;i++) {
        	sql = sql + wheres[i]+"like? or ";  
        }
        sql = sql + wheres[wheres.length-1]+"like ?";
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);
            for(int i = 0; i < wheres.length;i++) {
            	psta.setString(i+1, "%"+key+"%");
            } 
            rs=psta.executeQuery();  
            while(rs.next()){  
            	 Song obj=new Song();  
                 //obj.setId(rs.getInt(1));
            	 obj.setSong_id(rs.getInt(1));
                 obj.setSong_title(rs.getString(2));
                 obj.setSong_uper(rs.getString(3));
                 //obj.setSong_len(rs.getString(3));
                 //obj.setSong_uper(rs.getString(4));
                 //obj.setSong_up_date(rs.getString(5));
                 //obj.setSong_click_num(rs.getInt(6));
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
	public static int getCount() {
		Connection con=null;  
        ResultSet rs=null;
		int count = 0;
		PreparedStatement ps = null;
		String sql = "select count(*) from "+tableName;
		try {
			con = BaseDao.getConnection();
		    if (con!=null) {
		    	ps=con.prepareStatement(sql);
		    	rs=ps.executeQuery();
		    	if(rs.next()) {
		    		count= 1000000000+rs.getInt(1);
		    		System.out.println("count:"+count);
		    	}
		}
		    } catch (Exception e) {
		// TODO: handle exception
		}finally{  
            try{  
                BaseDao.close(rs, ps, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return count;  
        }  
	}
	public static int addNewSong(String title, String uper, String path) {
		Connection con=null;
        PreparedStatement psta=null;  
        ResultSet rs=null;
		String sql = String.format("INSERT INTO %s (id,title,uper,path,status) VALUES(?,?,?,?,?)", tableName);
		boolean isFalse = true;
		try{
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);
            psta.setInt(1, getCount());
    		psta.setString(2, title);
    		psta.setString(3, uper);
    		psta.setString(4, path);
    		psta.setInt(5, 1);
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
	public static int findCountByKye(String title, String uper) {
		Connection con=null;  
        ResultSet rs=null;
		int count = 0;
		PreparedStatement ps = null;
		String sql = "select count(*) from "+tableName+" where status = 1 and title=? and uper=?";
		try {
			con = BaseDao.getConnection();
		    if (con!=null) {
		    	ps=con.prepareStatement(sql);
		    	ps.setString(1,title);
		    	ps.setString(2, uper);
		    	rs=ps.executeQuery();
		    	if(rs.next()) {
		    		count=rs.getInt(1);
		    		System.out.println("exist count:"+count);
		    	}
		}
		    } catch (Exception e) {
		// TODO: handle exception
		}finally{  
            try{  
                BaseDao.close(rs, ps, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return count;  
        } 
	}
	public static ArrayList findByKey(String key) {
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList list=new ArrayList();  
        String sql=String.format("select id, title, uper from %s where status = 1 and (title like ? or uper like ?)", tableName);
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);
            psta.setString(1, "%"+key+"%");
            psta.setString(2, "%"+key+"%");
            rs=psta.executeQuery();  
            while(rs.next()){  
           	 	Song obj=new Song();  
                //obj.setId(rs.getInt(1));
           	 	obj.setSong_id(rs.getInt(1));
                obj.setSong_title(rs.getString(2));
                obj.setSong_uper(rs.getString(3));
                //obj.setSong_len(rs.getString(3));
                //obj.setSong_uper(rs.getString(4));
                //obj.setSong_up_date(rs.getString(5));
                //obj.setSong_click_num(rs.getInt(6));
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
	public static ArrayList findSongByUper(String key) {
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        ArrayList list=new ArrayList();  
        String sql=String.format("select id, title from %s where status = 1 and uper = ?", tableName);
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);
            psta.setString(1, key);
            rs=psta.executeQuery();  
            while(rs.next()){  
           	 	Song obj=new Song();  
                //obj.setId(rs.getInt(1));
           	 	obj.setSong_id(rs.getInt(1));
                obj.setSong_title(rs.getString(2));
                //obj.setSong_uper(rs.getString(3));
                //obj.setSong_len(rs.getString(3));
                //obj.setSong_uper(rs.getString(4));
                //obj.setSong_up_date(rs.getString(5));
                //obj.setSong_click_num(rs.getInt(6));
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
	public static int updateStatusById(int _id) {
		String sql = String.format("UPDATE %s SET status = ? WHERE id = ?", tableName);
		Connection con=null;
        PreparedStatement psta=null;  
        ResultSet rs=null;
		boolean isFalse = true;
		try{
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);
            psta.setInt(1, 0);
    		psta.setInt(2, _id);
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
	public static String findPathById(String info) {
		// TODO Auto-generated method stub
		Connection con=null;  
        PreparedStatement psta=null;  
        ResultSet rs=null;  
        Song obj=null;  
        String sql=String.format("select path from %s where id=?",tableName); 
        String filepath = null;
        try{  
            con=BaseDao.getConnection();  
            psta=con.prepareStatement(sql);  
            psta.setInt(1, Integer.parseInt(info));
            rs=psta.executeQuery();  
            if(rs.next()){  
            	 obj=new Song();  
                 //obj.setId(rs.getInt(1));
                 filepath = rs.getString(1);
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try{  
                BaseDao.close(rs, psta, con);  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            return filepath;  
        }  
	}
}
