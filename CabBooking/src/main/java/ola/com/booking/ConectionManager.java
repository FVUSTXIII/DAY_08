package ola.com.booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectionManager {

	public static Connection conn; 
	
	public static Connection getConnection() {
	String url = "jdbc:mysql://localhost:3306/cabbooking?characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=?characterEncoding=utf8&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Mexico_City";
	String username = "root";
	String password = "Juanoteesparz4";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("hola?");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;		
	}

}
