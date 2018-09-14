package com.zixuehizhilu.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	
	private static final ConnectionFactory FACTORY = new ConnectionFactory();
	
	private static Connection conn;
	
	
	static {
		//定义一个properties类,专门用来获取配置文件的键值对
		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("============配置文件读取错误==============");
			System.err.println("此文件一般在src目录下,目前读取的文件叫做dbconfig.properties");
		}
		driver = prop.getProperty("driver");
		System.out.println(driver);
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		
	}
	
	private ConnectionFactory() {
		
	}
	
	public static ConnectionFactory getInstance() {
		return FACTORY;
	}
	
	public  Connection mackConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("这里出错了");
		}
		return conn;
	} 
}
