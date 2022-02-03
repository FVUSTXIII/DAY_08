package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.UserDao;
import ola.com.booking.model.User;

public class UserDaoImpl implements UserDao {

	Connection conn= ConectionManager.getConnection();
	
	@Override
	public void saveUser(User user) {
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into User (email, name, password, phoneNo) values (?,?,?,?)");
			
			stmt.setString(1, user.getEmail());
			stmt.setString(2,user.getName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getPhoneNo());
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public User validateUser(String username, String password) {
		User user = new User();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE name=? and password=?");
		    stmt.setString(1, username);
		    stmt.setString(2, password);
		    ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				user.setId(rs.getInt("userId"));
				user.setName(rs.getString("name"));
				user.setPhoneNo(rs.getString("phoneNo"));
				user.setEmail(rs.getString("email"));
			}
			System.out.println("Estamos en validateUser: " + user.getuserId());
		    return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
