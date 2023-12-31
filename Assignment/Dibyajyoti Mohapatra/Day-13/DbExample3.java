package iiginternship;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbExample3 {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public DbExample3() {
		try {
			// Step-1: Load and register driver
			Class.forName("org.gjt.mm.mysql.Driver");
	
			// Step-2: Create Connection object
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_6","root","");

			// Step-3: Create a Statement object
			stmt = conn.createStatement();
			
			// Step-4: Create a ResultSet object
			rs = stmt.executeQuery("SELECT * FROM colleges");
			
			// Step-5: Manipulate ResultSet
			while(rs.next()) {
				System.out.println(rs.getInt("slno_id")+"  "+
	                       rs.getString("clg_name")+"  "+
				           rs.getString("address"));
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
		new DbExample3();
	}

}