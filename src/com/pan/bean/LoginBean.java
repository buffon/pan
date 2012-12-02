package com.pan.bean;

import com.pan.base.BaseBean;

public class LoginBean extends BaseBean {

	private static final long serialVersionUID = 1L;

	private String email;
	private String username;
	private String password;
	private String role;
	private String sex;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "username = " + username + "; password = " + password;
	}

}
