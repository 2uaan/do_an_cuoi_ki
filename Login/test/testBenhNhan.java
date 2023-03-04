package test;

import java.util.ArrayList;

import dao.BenhNhanDAO;
import model.BenhNhan;

public class testBenhNhan {
	public static void main(String[] args) {
		
		BenhNhan bn = new BenhNhan("051","Minh Man", "nam", "15/02/1998", "Ha Noi",  "Viem Gan","01/01/2023", "Minh Quan", 303);
		
		BenhNhanDAO.get().insert(bn);
		
//		ArrayList<BenhNhan> list = BenhNhanDAO.get().selectALL();
//		
//		for (BenhNhan benhNhan : list) {
//			System.out.println(benhNhan.toString());
//		}
//		
//		System.out.println("------------------------------------------");
//		BenhNhan bn1= new BenhNhan();
//		bn1.setMaBN("102");
//		BenhNhan bn= BenhNhanDAO.get().selectById(bn1);
//		System.out.println(bn);
//		
//		System.out.println("------------------------------------------");
//        ArrayList<BenhNhan> list1 = BenhNhanDAO.get().selectByCondition("phong=303");
//		
//		for (BenhNhan benhNhan : list1) {
//			System.out.println(benhNhan.toString());
//		}
		
	}
}
