package com.pan.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.pan.tools.StaticResourcesManager;


public abstract class DataBaseManager {

	public static Queue<Connection> pool = null;
	
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
	static {
		
		/*init pool*/
		pool = new LinkedList<Connection>();
		for(int index =0;index<Integer.parseInt(
				StaticResourcesManager.getResources("poolNumber").toString());
				index++){
			Connection connection = getInitConn();
			pool.offer(connection);
		}
	}
	
	public static <T extends DataBaseManager> T getIns(Class<T> clazz){
		try {
			return (T) clazz.newInstance();
		} catch (Exception e) {
			return null;
		}
			
	}

	public static Connection getConnection() {
       
		if (pool.size() > 0) {
			return pool.poll();
		} else {
			Connection connection = getInitConn();
			return connection;
		}
	}
	
	public static void releaseConnection(Connection conn){
		pool.offer(conn);
	}
	
	private static Connection getInitConn(){
		Connection connection = null;
		try {
			Class.forName(StaticResourcesManager.getResources("className"));
			connection = DriverManager.getConnection(
					StaticResourcesManager.getResources("url"),
					StaticResourcesManager.getResources("username"),
					StaticResourcesManager.getResources("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public String getNameByUserid(String userid) throws Exception{
		String sql = "select * from employee where id = ?";
		ResultSet rs = handleSQL(sql, userid);
		if(rs.next()){
			return rs.getString("name");
		}else{
			return "";
		}
	}
	
	public ResultSet handleSQL(String sql, String... params) throws SQLException{
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		for(int i = 1; i <= params.length; i++){
			stmt.setString(i, params[i-1]);
		}
		return stmt.executeQuery();	
	}
	
	public List<String> getAllUsername() throws SQLException{
		Connection conn = getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select name from employee");
		List<String> names = new ArrayList<String>();
		while(rs.next()){
			names.add(rs.getString(1));
		}
		return names;
	}
}
