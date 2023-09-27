package com.day_16;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


public class Start extends JFrame {
	private static final long serialVersionUID = 1L;
	public JSplitPane split;
	public JDesktopPane desktop;
	private JTable tblData;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	public Start() {
		this.setLayout(new BorderLayout());
		this.setTitle("Stock Accounting");
		this.setIconImage(new ImageIcon("project-icon.png").getImage());

		JToolBar toolBar = this.addToolBar();
		this.add(toolBar, BorderLayout.NORTH);

		
		JMenuBar mbar = new JMenuBar();
		this.setJMenuBar(mbar);
			JMenu mnuMaster = new JMenu("Master");
			mbar.add(mnuMaster);
				JMenuItem mnuManufacturer = new JMenuItem("Manufacturer");
				JMenuItem mnuProduct = new JMenuItem("Product");
				JMenuItem mnuVendor = new JMenuItem("Vendor");
				JMenuItem mnuCustomer = new JMenuItem("Customer");
				JMenuItem mnuActivities = new JMenuItem("Activities");
				mnuProduct.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						System.out.println("Product");
					}
				});
				mnuMaster.add(mnuManufacturer);
				mnuMaster.add(mnuProduct);
				mnuMaster.addSeparator();
				mnuMaster.add(mnuVendor);
				mnuMaster.add(mnuCustomer);
				mnuMaster.addSeparator();
				mnuMaster.add(mnuActivities);

			JMenu mnuTran = new JMenu("Transaction");
			mbar.add(mnuTran);
				JMenuItem mnuStockEntry = new JMenuItem("Stock Entry");
				JMenu mnuStockReports = new JMenu("Stock Reports");
					JMenuItem mnuCurrentStock = new JMenuItem("Current Stock", new ImageIcon("current-stock.png"));
					JMenuItem mnuPurchase = new JMenuItem("Purchase");
					JMenuItem mnuSales = new JMenuItem("Sales");
				JMenuItem mnuStockAdjustment = new JMenuItem("Stock Adjustment");
				mnuTran.add(mnuStockEntry);
				mnuTran.addSeparator();
				mnuTran.add(mnuStockReports);
					mnuStockReports.add(mnuCurrentStock);
					mnuStockReports.add(mnuPurchase);
					mnuStockReports.add(mnuSales);
				mnuTran.addSeparator();
				mnuTran.add(mnuStockAdjustment);

			JMenu mnuTools = new JMenu("Tools");
			mbar.add(mnuTools);

			JMenu mnuExit = new JMenu("Exit");
			mbar.add(mnuExit);

		desktop = new JDesktopPane();
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel(), desktop);
		split.setDividerLocation(250);
		this.add(split, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height-50);
		this.setVisible(true);
		
	}


	private JToolBar addToolBar() {
		JToolBar tb = new JToolBar();
		JButton btnExit = new JButton(new ImageIcon("ExitBTN.jpg"));
		JButton btnStock = new JButton(new ImageIcon("Image2.jpg"));
		JButton btnBrocker = new JButton(new ImageIcon("Image3.jpg"));
		JButton btnGrowing = new JButton(new ImageIcon("Image4.png"));
		JButton btnOffer= new JButton(new ImageIcon("Images5.png"));
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		tb.add(btnExit);
		tb.add(btnStock);
		tb.add(btnBrocker);
		tb.add(btnGrowing);
		tb.add(btnOffer);
		return tb;
	}

	private JPanel buttonPanel() {
		JPanel pnlButtons = new JPanel(new GridLayout(15,1));
		JLabel lblMaster = new JLabel("MASTER:-", JLabel.LEFT);
		lblMaster.setBorder(BorderFactory.createRaisedBevelBorder());
		lblMaster.setBackground(Color.lightGray);
		lblMaster.setForeground(Color.blue);
		lblMaster.setOpaque(true);
		JButton btnManufacturer = new JButton("Manufacturer");
		JButton btnProduct = new JButton("Product");
		JButton btnVendor = new JButton("Vendor");
		JButton btnCustomer = new JButton("Customer");
		JButton btnActivity = new JButton("Activity");
		pnlButtons.add(lblMaster);
		pnlButtons.add(btnManufacturer);
		pnlButtons.add(btnProduct);
		pnlButtons.add(btnVendor);
		pnlButtons.add(btnCustomer);
		pnlButtons.add(btnActivity);
		
		JLabel lblTransaction = new JLabel("TRANSACTION:-", JLabel.LEFT);
		lblTransaction.setBorder(BorderFactory.createRaisedBevelBorder());
		lblTransaction.setBackground(Color.lightGray);
		lblTransaction.setForeground(Color.blue);
		lblTransaction.setOpaque(true);
		pnlButtons.add(lblTransaction);
		JButton btnTransaction = new JButton("Stock Transaction");
		JButton btnStock = new JButton("Stock-Report");
		JButton btnStockAdj = new JButton("Stock-Adjesement");
		pnlButtons.add(btnTransaction);
		pnlButtons.add(btnStock);
		pnlButtons.add(btnStockAdj);
		
		
		JLabel lblTools = new JLabel("TOOLS:-",JLabel.LEFT);
		lblTools.setBorder(BorderFactory.createRaisedBevelBorder());
		lblTools.setBackground(Color.lightGray);
		lblTools.setForeground(Color.blue);
		lblTools.setOpaque(true);
		pnlButtons.add(lblTools);
		JButton btnBrokerageAcc = new JButton(" Brokerage-Account");
		JButton btnMarketsimulator = new JButton("Stock-Marke-Simulator");
		JButton btnPlatform = new JButton(" Charting-Platform");
		JButton btnSource = new JButton("News-Source");
		pnlButtons.add(btnBrokerageAcc);
		pnlButtons.add(btnMarketsimulator);
		pnlButtons.add(btnPlatform);
		pnlButtons.add(btnSource);
		
		
		
//		Manufacture Functioning 
		btnManufacturer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				JInternalFrame iManudfacture = new JInternalFrame("Product");
				iManudfacture.setLayout(new BorderLayout(5,5));
				iManudfacture.setResizable(true);
				iManudfacture.setClosable(true);
				iManudfacture.setIconifiable(true);
				iManudfacture.setMaximizable(true);

				JPanel pnlBottom = new JPanel(new GridLayout(1,6));
				iManudfacture.add(pnlBottom, BorderLayout.SOUTH);
				JButton btnAdd = new JButton("Add");
				
				JButton btnEdit = new JButton("Edit");
				JButton btnDelete = new JButton("Delete");
				JButton btnSearch = new JButton("Search");
				JButton btnPrint = new JButton("Print");
				JButton btnExit = new JButton("Exit");
				btnExit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						iManudfacture.dispose();
					}
				});
				pnlBottom.add(btnAdd);
				pnlBottom.add(btnEdit);
				pnlBottom.add(btnDelete);
				pnlBottom.add(btnSearch);
				pnlBottom.add(btnPrint);
				pnlBottom.add(btnExit);
			
				
				desktop.add(iManudfacture);
				iManudfacture.setBounds(0,0,desktop.getWidth(),desktop.getHeight()-1);
				iManudfacture.setVisible(true);
			}
		});
		
		
//		Product functioning 
		btnProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				JInternalFrame iProduct = new JInternalFrame("Product");
				iProduct.setLayout(new BorderLayout(5,5));
				iProduct.setResizable(true);
				iProduct.setClosable(true);
				iProduct.setIconifiable(true);
				iProduct.setMaximizable(true);

				JPanel pnlBottom = new JPanel(new GridLayout(1,6));
				iProduct.add(pnlBottom, BorderLayout.SOUTH);
				JButton btnAdd = new JButton("Add");
				JButton btnEdit = new JButton("Edit");
				JButton btnDelete = new JButton("Delete");
				JButton btnSearch = new JButton("Search");
				JButton btnPrint = new JButton("Print");
				JButton btnExit = new JButton("Exit");
				btnExit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						iProduct.dispose();
					}
				});
				pnlBottom.add(btnAdd);
				pnlBottom.add(btnEdit);
				pnlBottom.add(btnDelete);
				pnlBottom.add(btnSearch);
				pnlBottom.add(btnPrint);
				pnlBottom.add(btnExit);
				
				desktop.add(iProduct);
				iProduct.setBounds(0,0,163,137);
				iProduct.setVisible(true);
			}
		});
//		Vendor functioning
		
		 
		btnVendor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				JInternalFrame ivendor = new JInternalFrame("Product");
				ivendor .setLayout(new BorderLayout(5,5));
				ivendor .setResizable(true);
				ivendor .setClosable(true);
				ivendor .setIconifiable(true);
				ivendor .setMaximizable(true);

				JPanel pnlBottom = new JPanel(new GridLayout(1,6));
				ivendor .add(pnlBottom, BorderLayout.SOUTH);
				JButton btnAdd = new JButton("Add");
				JButton btnEdit = new JButton("Edit");
				JButton btnDelete = new JButton("Delete");
				JButton btnSearch = new JButton("Search");
				JButton btnPrint = new JButton("Print");
				JButton btnExit = new JButton("Exit");
				btnExit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ivendor .dispose();
					}
				});
				pnlBottom.add(btnAdd);
				pnlBottom.add(btnEdit);
				pnlBottom.add(btnDelete);
				pnlBottom.add(btnSearch);
				pnlBottom.add(btnPrint);
				pnlBottom.add(btnExit);
				
				desktop.add(ivendor );
				ivendor .setBounds(0,0,1020,580);
				ivendor .setVisible(true);
			}
		});
		
//		customer functioning
		btnCustomer.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent ae) {
//				************************
//				btnAdd.addActionListener(new ActionListener(){
//					public void actionPerformed(ActionEvent e) {
						try {
							Class.forName("org.gjt.mm.mysql.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_accounting","root","");
							stmt = conn.createStatement();
							rs = stmt.executeQuery("select * from customer");
							ResultSetMetaData rsmd = rs.getMetaData();       
							tblData=new JTable(new CustomerTableModel(rs) );
//							this.add(new JScrollPane(tblData));
							//DefaultTableModel model =(DefaultTableModel)tblData.getModel();
							int cols=rsmd.getColumnCount();
							String[] colName = new String[cols];
							for(int i=0;i<cols;i++) 
								colName[i]=rsmd.getColumnName(i+1);
							//model.setColumnIdentifiers(colName);
						
						while (rs.next()) {
							System.out.println(rs.getInt(1)+
							rs.getString(2)+
							rs.getString(3)+
							rs.getString(4)+
							rs.getDouble(5)+
							rs.getInt(6));
						}
						
						} catch(ClassNotFoundException e1) {
							System.out.println(e1);
						} catch(SQLException e1) {
							System.out.println(e1);
						}
					                         
//						add(new JScrollPane(tblData));
//						pack();
//						setVisible(true);
//					}
//				});
//				************************
				JInternalFrame iCoustemer = new JInternalFrame("Customer");
				iCoustemer.setLayout(new BorderLayout(5,5));
				iCoustemer.setResizable(true);
				iCoustemer.setClosable(true);
				iCoustemer.setIconifiable(true);
				iCoustemer.setMaximizable(true);
				JPanel pnlBottom = new JPanel(new GridLayout(1,6));
				iCoustemer.add(pnlBottom, BorderLayout.SOUTH);
				JButton btnAdd = new JButton("Add");
				JButton btnEdit = new JButton("Edit");
				JButton btnDelete = new JButton("Delete");
				JButton btnSearch = new JButton("Search");
				JButton btnPrint = new JButton("Print");
				JButton btnExit = new JButton("Exit");
				btnExit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						iCoustemer.dispose();
					}
				});
				pnlBottom.add(btnAdd);
				pnlBottom.add(btnEdit);
				pnlBottom.add(btnDelete);
				pnlBottom.add(btnSearch);
				pnlBottom.add(btnPrint);
				pnlBottom.add(btnExit);
				
				desktop.add(iCoustemer);
				iCoustemer.setBounds(0,0,desktop.getWidth(),desktop.getHeight()-1);
				iCoustemer.setVisible(true);
			}

		
		});
//		Activity functioning
		btnActivity.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				JInternalFrame iActivity = new JInternalFrame("Product");
				iActivity.setLayout(new BorderLayout(5,5));
				iActivity.setResizable(true);
				iActivity.setClosable(true);
				iActivity.setIconifiable(true);
				iActivity.setMaximizable(true);

				JPanel pnlBottom = new JPanel(new GridLayout(1,6));
				iActivity.add(pnlBottom, BorderLayout.SOUTH);
				JButton btnAdd = new JButton("Add");
				JButton btnEdit = new JButton("Edit");
				JButton btnDelete = new JButton("Delete");
				JButton btnSearch = new JButton("Search");
				JButton btnPrint = new JButton("Print");
				JButton btnExit = new JButton("Exit");
				btnExit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						iActivity.dispose();
					}
				});
				pnlBottom.add(btnAdd);
				pnlBottom.add(btnEdit);
				pnlBottom.add(btnDelete);
				pnlBottom.add(btnSearch);
				pnlBottom.add(btnPrint);
				pnlBottom.add(btnExit);
				
				desktop.add(iActivity);
				iActivity.setBounds(0,0,1020,580);
				iActivity.setVisible(true);
			}
		});
		return pnlButtons;
	}
	
	public static void main(String[] args) {
		new Start();
	}

}

class CustomerTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public ResultSet rs;
	public ResultSetMetaData rsmd;
	
	public CustomerTableModel(ResultSet rs) {
		this.rs = rs;
	}

	@Override
	public int getRowCount() {
		int maxRow = 0;
		try {
			int row = rs.getRow();
			
			if(rs.isBeforeFirst()) {
				rs.last();
				maxRow = rs.getRow();
				rs.beforeFirst();
			} else if(rs.isAfterLast()) {
				rs.last();
				maxRow = rs.getRow();
				rs.afterLast();
			} else {
				rs.last();
				maxRow = rs.getRow();
				rs.absolute(row);
			}
		} catch(SQLException e) {
		} catch(Exception e) {
		}
		return maxRow;
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
