package com.simple.DAO;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;


public class JdbcPool implements DataSource {
	private static LinkedList<Connection> listConnections = new LinkedList<Connection>();
	static {
		InputStream in = JdbcPool.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			int jdbcPoolInitSize = Integer.parseInt(prop.getProperty("jdbcPoolInitSize"));
			Class.forName(driver);
			for(int i = 0; i < jdbcPoolInitSize; i++) {
				Connection conn = DriverManager.getConnection(url,username, password);
				listConnections.add(conn);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		if(listConnections.size()>0) {
			final Connection conn = listConnections.removeFirst();
			System.out.println("listConnections size : "+listConnections.size());
			return (Connection) Proxy.newProxyInstance(
					JdbcPool.class.getClassLoader(),
					new Class[] {Connection.class}, 
					new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable{
					if(!method.getName().equals("close")) {
						return method.invoke(conn, args);
					}else {
						listConnections.add(conn);
						System.out.println(conn + "return back to connection pool");
						System.out.println("listConnections size : "+listConnections.size());
						return null;
					}
				}
			});
		}else {
			throw new RuntimeException("Sorry, Database is busy");
		}
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
