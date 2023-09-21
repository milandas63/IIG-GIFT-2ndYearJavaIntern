package com.day15;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ProductMaintenance extends JFrame {
	JTable table;
	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	public ResultSetMetaData rsmd;
	
	public ProductMaintenance() {
		this.setLayout(new BorderLayout());

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_accounting", "root", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT p.product_id,p.product_desc,m.mfg_desc,k.pack_desc FROM product AS p LEFT JOIN manufacturer AS m ON p.mfg_id=m.mfg_id LEFT JOIN packing AS k ON p.pack_id=k.pack_id");
			rsmd = rs.getMetaData();
			
			table = new JTable(new MyTableModel(rs));
			this.add(table, BorderLayout.CENTER);

		} catch(ClassNotFoundException e) {
		} catch(SQLException e) {
		} catch(Exception e) {
		}
		
		
		this.setBounds(100,100,500,400);
		this.setVisible(true);
	}
}

class MyTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public ResultSet rs;
	public ResultSetMetaData rsmd;
	
	
	public MyTableModel(ResultSet rs) {
		this.rs = rs;
		try {
			this.rsmd = rs.getMetaData();
		} catch(SQLException e) {
		} catch(Exception e) {
		}
	}

	@Override
	public int getColumnCount() {
		int maxCol = 0;
		try {
			maxCol = rsmd.getColumnCount();
		} catch(SQLException e) {
		} catch(Exception e) {
		}
		return maxCol;
	}

	@Override
	public int getRowCount() {
		int maxRow = 0;
		try {
			int row = rs.getRow();
			rs.last();
			maxRow = rs.getRow();
			rs.absolute(row);
		} catch(SQLException e) {
		} catch(Exception e) {
		}
		return maxRow;
	}

	@Override
	public Object getValueAt(int row, int col) {
		Object colData = null;
		try {
			rs.absolute(row+1);
			colData = rs.getObject(col+1);
		} catch(SQLException e) {
		} catch(Exception e) {
		}
		return colData;
	}
	
}