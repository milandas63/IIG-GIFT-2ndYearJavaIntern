package com.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
					public void actionPerformed(ActionEvent arg0) {
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

		JToolBar toolBar = new JToolBar();

		desktop = new JDesktopPane();
		split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel(), desktop);
		this.add(split, BorderLayout.CENTER);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(25,25,1300,680);
		this.setVisible(true);
	}

	private JPanel buttonPanel() {
		JPanel pnlButtons = new JPanel(new GridLayout(10,1));
		JButton btnProduct = new JButton("Product");
		JButton btnManufacturer = new JButton("Manufacturer");
		JButton btnVendor = new JButton("Vendor");
		JButton btnCustomer = new JButton("Customer");
		pnlButtons.add(btnProduct);
		pnlButtons.add(btnManufacturer);
		pnlButtons.add(btnVendor);
		pnlButtons.add(btnCustomer);
		btnProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				JInternalFrame iProduct = new JInternalFrame("Product");
				iProduct.setResizable(true);
				iProduct.setClosable(true);
				iProduct.setIconifiable(true);
				iProduct.setMaximizable(true);

				desktop.add(iProduct);
				iProduct.setBounds(0,0,600,400);
				iProduct.setVisible(true);
			}
		});
		return pnlButtons;
	}
	
	public static void main(String[] args) {
		new Start();
	}

}
