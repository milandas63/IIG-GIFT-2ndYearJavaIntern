package com.day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbExample2 {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public DbExample2() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_3","root","");
			stmt = conn.createStatement();
			//stmt.executeUpdate("INSERT INTO students(name,regd_no) values('Anwesha Mahapatra',2101298063)");
			stmt.executeUpdate("UPDATE students SET name='Arti Kumari', regd_no=2101298064 WHERE slno=2");

			rs = stmt.executeQuery("SELECT * FROM students");

			while(rs.next()) {
				System.out.println(rs.getInt("slno")+"  "+
			                       rs.getString("name")+"  "+
						           rs.getInt("regd_no"));
			}

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
		new DbExample2();
	}

}
