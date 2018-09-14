package com.zixuehizhilu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TranTest {

	public static Connection getConnection(){
		Connection conn = null;
		try {
			//注册JDBC驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取mysql的数据库链接,三个参数,第一个,url,第二个,用户名,第三年,密码
			//
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oneshop?serverTimezone=GMT","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void insert(Connection conn) throws SQLException{
			String sql = "INSERT INTO ace_config(id,CKEY,CVALUE,config_style,config_rank,configexplain) "+
							"VALUES(14,'WEBURL','www.baidu.com','1','1','这是刚才添加的数据')";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向表中插入了"+count+"条数据");
	}
	
	public static void update(Connection conn) throws SQLException{
			String sql = "UPDATE ff ace_config SET CVALUE = '3333' WHERE id = 15";
			Statement st = conn.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("向表中更新了"+count+"条数据");
		
	}
	
	
	public static void main(String[] args) {
			Connection conn = null;
			try {
				conn = getConnection();
				//开启事务
				conn.setAutoCommit(false);
				insert(conn);
				update(conn);
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				try {
					conn.rollback();
					System.out.println("事务回滚成功");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}finally{
				try {
					if(conn != null){
						conn.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
	}

}
