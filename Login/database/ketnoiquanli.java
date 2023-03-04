package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ketnoiquanli {
   public static Connection getConnection() {
	   Connection c = null;
	   
	   try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String url ="jdbc:mySQL://localhost:3306/ketnoicsdl";
		String username = "root";
		String password = "";
		
		c = DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return c;
   }
   
   public static void closeConnection(Connection c) {
	   try {
		if (c!=null) {
			c.close();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
}
