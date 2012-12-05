package com.pan.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pan.bean.MissionBean;

public class AdminImplDB extends DataBaseManager {

	public List<MissionBean> getAllMissions() throws Exception{
		Connection conn = getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select * from mainmission order by id desc");
		List<MissionBean> missions = new ArrayList<MissionBean>();
		while(rs.next()){
			MissionBean bean = new MissionBean();
			bean.setId(rs.getString("id"));
			bean.setMissionname(rs.getString("missionname"));
			bean.setUsername(getNameByUserid(rs.getString("userid")));
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
		return missions;
	}
}
