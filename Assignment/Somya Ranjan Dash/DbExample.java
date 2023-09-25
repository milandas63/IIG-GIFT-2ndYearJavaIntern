package com.day11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbExample {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public DbExample() {
		try {
			// Step-1: Load and register driver
			Class.forName("org.gjt.mm.mysql.Driver");
	
			// Step-2: Create Connection object
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_3","root","");

			// Step-3: Create a Statement object
			stmt = conn.createStatement();
			
			// Step-4: Create a ResultSet object
			rs = stmt.executeQuery("SELECT * FROM students");
			
			// Step-5: Manipulate ResultSet
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+
			                       rs.getString(2)+"  "+
						           rs.getInt(3));
			}
			
			// Step-6: Close ResultSet, Statement, Connection
			rs.close();
			stmt.close();
			conn.close();
			
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DbExample();
	}

}
