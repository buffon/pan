package com.pan.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pan.bean.DMissionBean;
import com.pan.bean.MissionBean;

public class ImplDB extends DataBaseManager {

	public boolean auth(String name, String password, String role) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee where name = ? and password = ?");
		stmt.setString(1, name);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			// Have no access.
//			if (rs.getString("role").equals("user") && role.equals("admin")) {
//			}
			if (rs.getString("role").equals(role)) {
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("user login failed");
			return false;
		}
	}
	
	public List<MissionBean> getMbyUserid(String userid) throws Exception{
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM mainmission where userid = ? order by id desc");
		stmt.setString(1, userid);
		ResultSet rs = stmt.executeQuery();
		List<MissionBean> missions = new ArrayList<MissionBean>();
		while(rs.next()){
			MissionBean bean = new MissionBean();
			bean.setId(rs.getString("id"));
			bean.setUsername(getNameByUserid(rs.getString("userid")));
			bean.setMissionname(rs.getString("missionname"));
			bean.setMissiondiscrip(rs.getString("missiondiscrip"));
			bean.setStartTime(rs.getString("starttime"));
			if(rs.getString("endtime") == null){
				bean.setEndTime("");
			}else{
			    bean.setEndTime(rs.getString("endtime"));
			}
			bean.setStatus(rs.getString("status"));
			missions.add(bean);
		}
		System.out.println(userid + " get mission-number "+ missions.size());
		return missions;
	}
	
	public String getUserdByName(String username) throws SQLException{
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employee where name = ?");
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			String id = rs.getString("id");
			System.out.println(username +" map to "+ id);
			return id;
		} else {
			System.out.println(username + " map nothing!");
			return "";
		}
	}

	public String getMNamebyMid(String mid) throws Exception{
		String sql = "select * from mainmission where id = ?";
		ResultSet rs = handleSQL(sql, mid);
		if(rs.next()){
			return rs.getString("missionname");
		}else{
			return "";
		}
	}
	
	public String getMidByMName(String userid, String mname) throws Exception{
		String sql = "select * from mainmission where missionname = ? and userid = ?";
		ResultSet rs = handleSQL(sql, mname, userid);
		if(rs.next()){
			return rs.getString("id");
		}else{
			return "";
		}
	}
	
	public boolean finishM(String mid) throws SQLException{
		String sql = "update mainmission set status = 'finished' , endtime = ? where id = ?";
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, df.format(new Date()));
		stmt.setString(2, mid);
		int rs = stmt.executeUpdate();
		System.out.println("update result = " + rs);
		if(rs > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean finishMDetail(String dmissionid) throws SQLException{
		String sql = "update dmission set status = 'finished' ,endtime = ? where id = ?";
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, df.format(new Date()));
		stmt.setString(2, dmissionid);
		int rs = stmt.executeUpdate();
		if(rs > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public List<DMissionBean> getDByMid(String mid) throws Exception{
		String sql = "select * from dmission where missionid = ?";
		ResultSet rs = handleSQL(sql, mid);
		List<DMissionBean> list = new ArrayList<DMissionBean>();
		while(rs.next()){
			DMissionBean bean = new DMissionBean();
			bean.setId(rs.getString("id"));
			bean.setHelper(getNameByUserid(rs.getString("helperid")));
			bean.setDescrip(rs.getString("description"));
			bean.setStatus(rs.getString("status"));
			bean.setStartTime(rs.getString("starttime"));
			if(rs.getString("endtime") == null){
				bean.setEndTime("");
			}else{
			    bean.setEndTime(rs.getString("endtime"));
			}
			list.add(bean);
		}
		return list;
	}
	
	public boolean addM(String missionname, String missiondiscrip, String userid) throws SQLException{
		String sql = "insert into mainmission(missionname,missiondiscrip,userid,status,starttime,endtime) values(?,?,?,?,?,?)";
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, missionname);
		stmt.setString(2, missiondiscrip);
		stmt.setString(3, userid);
		stmt.setString(4, "running");
		stmt.setString(5, df.format(new Date()));
		stmt.setString(6, "");
		int set = stmt.executeUpdate();
		if(set == 1){
		    return true;
		} else {
			return false;
		}
	}
	
	public boolean addMDetail(String missionid, String helperid,String content) throws SQLException{
		String sql = "insert into dmission(missionid,helperid,description,status,starttime) values(?,?,?,?,?)";
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, missionid);
		stmt.setString(2, helperid);
		stmt.setString(3, content);
		stmt.setString(4, "running");
		stmt.setString(5, df.format(new Date()));
		int set = stmt.executeUpdate();
		if(set == 1){
		    return true;
		} else {
			return false;
		}
	}
}
