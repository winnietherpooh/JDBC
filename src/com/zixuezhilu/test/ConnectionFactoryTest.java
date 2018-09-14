package com.zixuezhilu.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.zixuehizhilu.util.ConnectionFactory;

public class ConnectionFactoryTest {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection conn = cf.mackConnection();
		System.out.println(conn.getAutoCommit());
	}

}
