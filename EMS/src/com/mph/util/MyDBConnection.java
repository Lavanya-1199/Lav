package com.mph.util;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection; 

public class MyDBConnection {
    static Connection con;
	public static Connection getDBConnection()
	{
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "lavanya11");
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		System.out.println(getDBConnection());
	}
	
}
