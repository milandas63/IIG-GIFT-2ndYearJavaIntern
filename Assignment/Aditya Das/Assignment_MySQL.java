package Day13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Assignment_MySQL {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public Assignment_MySQL() {
		try {
			
			Class.forName("org.gjt.mm.mysql.Driver");
	
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern","root","");

		
			stmt = conn.createStatement();
			
			
			rs = stmt.executeQuery("SELECT * FROM colleges");
			
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+
			                       rs.getString(2)+"  "+
						           rs.getInt(3));
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
		new Assignment_MySQL();
	}

}