package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ketnoiquanli;
import database.ketnoithu;
import model.BenhNhan;

public class BenhNhanDAO implements DAOInterface<BenhNhan>{
	
	public static BenhNhanDAO get() {
		return new BenhNhanDAO();
	}

	@Override
	public void insert(BenhNhan t) {
		
		try {
			Connection con = ketnoiquanli.getConnection();
			
			Statement st = con.createStatement();
			
			String sql ="INSERT INTO benhnhan (hoVaten, gioiTinh, ngaySinh, queQuan, ngayVaoVien, tenBenh, tenBacSi, phong)"+
						" VALUES ('"+t.getMaBN()+"','"+t.getHoVaTen()+"','"+t.getGioiTinh()+"','"+t.getNgaySinh()+"','"+t.getQueQuan()+"','"+t.getTenBenh()+"','"+
						t.getNgayVaoVien()+"','"+t.getTenBacSi()+"',"+t.getPhong()+")";
			
			int check = st.executeUpdate(sql);
		
			ketnoiquanli.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		return 0;
	}

	@Override
	public int update(BenhNhan t) {try {
		Connection con = ketnoiquanli.getConnection();
		
		Statement st = con.createStatement();
		
		String sql =" UPDATE benhnhan "+
					" SET "+
					" hoVaTen= '"+ t.getHoVaTen()+"',"+
					" gioiTinh= '"+ t.getGioiTinh()+"',"+
					" ngaySinh= '"+ t.getNgaySinh()+"',"+
					" queQuan= '"+ t.getQueQuan()+"',"+
					" ngayVaoVien= '"+ t.getNgayVaoVien()+"',"+
					" tenBenh= '"+ t.getTenBenh()+"',"+
					" tenBacSi= '"+ t.getTenBacSi()+"',"+
					" phong= "+ t.getPhong()+
					" Where MaBN="+t.getMaBN();
		
		System.out.println(sql);
		int check = st.executeUpdate(sql);
		
	
		ketnoiquanli.closeConnection(con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return 0;
	}

	@Override
	public int delete(BenhNhan t) {
		try {
			Connection con = ketnoiquanli.getConnection();
			
			Statement st = con.createStatement();
			
			String sql =" DELETE FROM benhnhan "+
						" Where MaBN="+t.getMaBN();
			
			int check = st.executeUpdate(sql);
		
			ketnoiquanli.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public ArrayList<BenhNhan> selectALL() {
		ArrayList<BenhNhan> ketqua = new ArrayList<BenhNhan>();
		try {
			Connection con = ketnoiquanli.getConnection();
			
			Statement st = con.createStatement();
			
			String sql ="SELECT * FROM benhnhan";
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String maBN= rs.getString("MaBN");
				String hoVaTen = rs.getString("hoVaTen");
				String gioiTinh= rs.getString("gioiTinh");
				String ngaySinh= rs.getString("ngaySinh");
				String queQuan= rs.getString("queQuan");
				String ngayVaoVien= rs.getString("ngayVaoVien");
				String tenBenh= rs.getString("tenBenh");
				String tenBacSi= rs.getString("tenBacSi");
				int phong = rs.getInt("phong");
			
				BenhNhan bn = new BenhNhan(maBN, hoVaTen, gioiTinh, ngaySinh, queQuan, ngayVaoVien, tenBenh, tenBacSi, phong);
				
				ketqua.add(bn);
				
			}
		
			ketnoiquanli.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public BenhNhan selectById(BenhNhan t) {
		BenhNhan ketqua = null;
		try {
			Connection con = ketnoiquanli.getConnection();
			
			Statement st = con.createStatement();
			
			String sql ="SELECT * FROM benhnhan Where MaBN='"+t.getMaBN()+"'";
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String maBN= rs.getString("MaBN");
				String hoVaTen = rs.getString("hoVaTen");
				String gioiTinh= rs.getString("gioiTinh");
				String ngaySinh= rs.getString("ngaySinh");
				String queQuan= rs.getString("queQuan");
				String ngayVaoVien= rs.getString("ngayVaoVien");
				String tenBenh= rs.getString("tenBenh");
				String tenBacSi= rs.getString("tenBacSi");
				int phong = rs.getInt("phong");
			
				ketqua = new BenhNhan(maBN, hoVaTen, gioiTinh, ngaySinh, queQuan, ngayVaoVien, tenBenh, tenBacSi, phong);
				
			}
		
			ketnoiquanli.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<BenhNhan> selectByCondition(String condition) {
		ArrayList<BenhNhan> ketqua = new ArrayList<BenhNhan>();
		try {
			Connection con = ketnoiquanli.getConnection();
			
			Statement st = con.createStatement();
			
			String sql ="SELECT * FROM benhnhan Where " + condition;
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String maBN= rs.getString("MaBN");
				String hoVaTen = rs.getString("hoVaTen");
				String gioiTinh= rs.getString("gioiTinh");
				String ngaySinh= rs.getString("ngaySinh");
				String queQuan= rs.getString("queQuan");
				String ngayVaoVien= rs.getString("ngayVaoVien");
				String tenBenh= rs.getString("tenBenh");
				String tenBacSi= rs.getString("tenBacSi");
				int phong = rs.getInt("phong");
			
				BenhNhan bn = new BenhNhan(maBN, hoVaTen, gioiTinh, ngaySinh, queQuan, ngayVaoVien, tenBenh, tenBacSi, phong);
				
				ketqua.add(bn);
				
			}
		
			ketnoiquanli.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

}
