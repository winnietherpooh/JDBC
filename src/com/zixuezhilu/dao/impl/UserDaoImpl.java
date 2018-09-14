package com.zixuezhilu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zixuezhilu.dao.UserDao;
import com.zixuezhilu.entity.User;

public class UserDaoImpl implements UserDao {

	/**
	 * 
	 */
	public void save(Connection conn, User user) throws SQLException {
			PreparedStatement ps = conn.prepareCall("INSERT INTO web_user (user_name,password,email) VALUES(?,?,?)");
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.execute();
	}

	public void update(Connection conn, Long id, User user) throws SQLException {
		String updatesql = "UPDATE web_user SET user_name = ?, password= ?, email = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(updatesql);
		ps.setString(1, user.getUser_name());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setLong(4, id);
		ps.execute();

	}

	public void delete(Connection conn, User user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM web_user WHERE id = ?");
		ps.setLong(1, user.getId());
		ps.execute();
	}

}
