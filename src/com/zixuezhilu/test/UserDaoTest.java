package com.zixuezhilu.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.zixuehizhilu.util.ConnectionFactory;
import com.zixuezhilu.dao.UserDao;
import com.zixuezhilu.dao.impl.UserDaoImpl;
import com.zixuezhilu.entity.User;

public class UserDaoTest {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().mackConnection();
			conn.setAutoCommit(false);
			UserDao userDao = new UserDaoImpl();
			User tom = new User();
			tom.setUser_name("TOM");
			tom.setPassword("123456");
			tom.setEmail("xxx@qq.com");
			userDao.save(conn, tom);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
