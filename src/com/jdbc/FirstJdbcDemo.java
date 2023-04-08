package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class FirstJdbcDemo {
	static Connection conn;
	static Connection con() {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","java123");
			
		}catch (Exception e) {

		}
		
		return conn;	
	}
}
