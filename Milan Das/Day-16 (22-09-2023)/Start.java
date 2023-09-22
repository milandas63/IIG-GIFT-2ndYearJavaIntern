package com.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

public class Start extends JFrame {
	private static final long serialVersionUID = 1L;
	public JSplitPane split;
	public JDesktopPane desktop;

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
		this.setBounds(25,25,1300,680);
		this.setVisible(true);
	}

	private JToolBar addToolBar() {
		JToolBar tb = new JToolBar();
		JButton btnExit = new JButton(new ImageIcon("exit.png"));
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		tb.add(btnExit);
		return tb;
	}
	
	private JPanel buttonPanel() {
		JPanel pnlButtons = new JPanel(new GridLayout(15,1));
		JLabel lblMaster = new JLabel("MASTER", JLabel.CENTER);
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
		
		JLabel lblTransaction = new JLabel("TRANSACTION", JLabel.CENTER);
		lblTransaction.setBorder(BorderFactory.createRaisedBevelBorder());
		lblTransaction.setBackground(Color.lightGray);
		lblTransaction.setForeground(Color.blue);
		lblTransaction.setOpaque(true);
		JButton btnTransaction = new JButton("Stock Transaction");
		pnlButtons.add(lblTransaction);
		pnlButtons.add(btnTransaction);
		
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
				iProduct.setBounds(0,0,800,450);
				iProduct.setVisible(true);
			}
		});
		return pnlButtons;
	}
	
	public static void main(String[] args) {
		new Start();
	}

}
