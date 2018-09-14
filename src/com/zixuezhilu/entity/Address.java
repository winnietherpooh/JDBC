package com.zixuezhilu.entity;

public class Address extends IdEntity{
	private String user_id;
	private String address;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Address [user_id=" + user_id + ", address=" + address + ", id=" + id + "]";
	}
	
}
