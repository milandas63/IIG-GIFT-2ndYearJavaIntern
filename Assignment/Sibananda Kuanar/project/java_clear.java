DefaultTableModel model
	= (DefaultTableModel)jTable1.getModel();
try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/vendor", "root",
		"root");
	String query = "SELECT* FROM RECORD;";
	ResultSet rs = stmt.executeQuery(query);
	while (rs.next()) {
		String serlno = rs.getString("serlno");
		String name = rs.getString("name");
		String product = rs.getString("product");
		String price = rs.getString("price");
		String adr = rs.getString("address");
		model.addRow(
			new Object[] { serlno, name, product, price, adr });
	}
	rs.close();
	stmt.close();
	con.close();
}
catch (Exception e) {
	JOptionPane.showMessageDialog(this,"Error In Connectivity");
}
