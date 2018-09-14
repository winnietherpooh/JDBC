package com.zixuezhilu.entity;

public class User extends IdEntity {
	private String user_name;
	private String password;
	private String email;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", password=" + password + ", email=" + email + ", id=" + id + "]";
	}
	
	
}
