import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VendorRecord extends javax.swing.JFrame {

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/vendor", "root",
			"root");
		stmt = con.createStatement();
		String serlno = jTextField1.getText();
		String name = jTextField2.getText();
		String product = jTextField3.getText();
		String price = jTextField4.getText();
		String adr = jTextArea1.getText();
		String INSERT = "INSERT INTO RECORD VALUES('"
						+ serlno + "','" + name + "','"
						+ product + "','" + price + "','" + adr
						+ "');";
		stmt.executeUpdate(INSERT);
		JOptionPane.showMessageDialog(
			this, "Record Added Successfully");
		jButton1.setEnabled(true);
	}
	catch (Exception e) {
		JOptionPane.showMessageDialog(
			this, "Error In Connectivity");
	}
