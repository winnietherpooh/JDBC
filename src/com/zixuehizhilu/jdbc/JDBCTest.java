package com.zixuehizhilu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCTest {

	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oneshop?serverTimezone=GMT","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void insert(){
		Connection conn = getConnection();
		try {
			String sql = "INSERT INTO ace_config(CKEY,CVALUE,config_style,config_rank,configexplain) "+
							"VALUES('WEBURL','www.baidu.com','1','1','���Ǹղ���ӵ�����')";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("����в�����"+count+"������");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(){
		Connection conn = getConnection();
		try {
			String sql = "UPDATE  ace_config SET CVALUE = '3333' WHERE id = 3";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("����и�����"+count+"������");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(){
		Connection conn = getConnection();
		try {
			String sql = "DELETE from ace_config  WHERE id = 3";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("�����ɾ����"+count+"������");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//insert();
		//update();
		delete();
		
	}

}
