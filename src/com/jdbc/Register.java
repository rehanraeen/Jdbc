package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {
	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);
	
	
	List<BeanReg> l = new ArrayList<>();
	
	
	List<BeanReg> be() throws SQLException {
		
		
		Statement statement;
		
			Connection con = FirstJdbcDemo.con();
			statement = con.createStatement();
			ResultSet query = statement.executeQuery("select * from reg ;");
			
			while (query.next()) {
				BeanReg be = new BeanReg();
				be.setId(query.getInt(1));
				be.setName(query.getString(2));
				be.setCity(query.getString(3));
				be.setPass(query.getLong(4));
				l.add(be);
				
			}
			System.out.println(l);
		
		return l;	
	}

	void add() throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		// FirstJdbcDemo fc = new FirstJdbcDemo();
		Connection con = FirstJdbcDemo.con();
		PreparedStatement ps = null;

		System.out.println("Enter Your ID");
		int id = sc.nextInt();

		System.out.println("Enter Your Name");
		String name = sc1.nextLine();

		System.out.println("Enter Your City");
		String city = sc1.next();

		System.out.println("Enter Your Password");
		long pass = sc.nextLong();

		System.out.println( "Your Detail  Id :"+id+", name :" + name+", City :" + city+", Password :" + pass);

		ps = con.prepareStatement("insert into reg values(?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, city);
		ps.setLong(4, pass);

		ps.executeUpdate();

		ps.close();

	}
	
	void login() throws SQLException {
		
		
		
		System.out.println("Enter Id");
		int id = sc1.nextInt();

		System.out.println("Enter Password");
		long pass = sc.nextLong();
		
		Connection con = FirstJdbcDemo.con();
		Statement statement = con.createStatement();
		ResultSet query = statement.executeQuery("select * from reg ;");
		
		Boolean bb = false;
		while (query.next()) {
			int id1 = query.getInt(1);
			int pass1 = query.getInt(4);
		
			if (pass == pass1 && id == id1) {
				System.out.println("login succes");
				System.out.println("your data");
			    ResultSet query2 = statement.executeQuery("select * from reg where id="+id1+"");
			    query2.next();
			    System.out.println(query2.getInt(1));
			    System.out.println(query2.getString(2));
			    System.out.println(query2.getString(3));
			    System.out.println(query2.getLong(4));
				System.out.println(query2);
				bb = true;
				break;
			}
			

		}
		if (bb == false) {
			System.out.println("wrong pass or id");
		}
	}


	public static void main(String[] args) {
		Register rg = new Register();
		Scanner sc = new Scanner(System.in);

		try {
			
			System.out.println("Press 1 to Register :");
			System.out.println("Press 2 to Login");
			System.out.println("Press 3 to Login");
			int no= sc.nextInt();
		   
			if(no==1) {
				rg.add();
			}
			else if(no==2) {
				rg.login();
			}
			else if(no==3) {
				rg.be();
			}
			else {
				System.out.println("Press Correct Button");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
