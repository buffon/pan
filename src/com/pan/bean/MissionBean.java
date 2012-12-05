package com.pan.bean;

import com.pan.base.BaseBean;

public class MissionBean extends BaseBean {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String userid;
	private String username;
	private String missionname;
	private String missiondiscrip;
	private String startTime;
	private String endTime;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMissionname() {
		return missionname;
	}
	public void setMissionname(String missionname) {
		this.missionname = missionname;
	}
	public String getMissiondiscrip() {
		return missiondiscrip;
	}
	public void setMissiondiscrip(String missiondiscrip) {
		this.missiondiscrip = missiondiscrip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
