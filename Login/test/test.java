package test;

import java.sql.Connection;

import database.ketnoiquanli;

public class test {
	public static void main(String[] args) {
		Connection c = ketnoiquanli.getConnection();
		System.out.println(c);
	}
}
