package com.pan.bean;

import com.pan.base.BaseBean;

public class MissionBean extends BaseBean {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String userid;
	private String missionname;
	private String missiondiscrip;
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
	
	

}
