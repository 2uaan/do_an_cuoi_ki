package test;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import database.ketnoithu;

public class testthu {

	public static void main(String[] args) {
		
		try {
			Connection c = ketnoithu.getConnection();
			
			java.sql.Statement st = c.createStatement();
			
			
			String sql = "INSERT INTO thulam (ten, tuoi, quequan)"
					+ "VALUES ('Dat',20,'Da Nang')";

			int check = st.executeUpdate(sql);
			
			System.out.println("So dong thay doi "+check);
			
			if (check!=0) {
				System.out.println("Them hang thanh cong");
			}else {
				System.out.println("Them hang khong thanh cong");
			}
			
			ketnoithu.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
