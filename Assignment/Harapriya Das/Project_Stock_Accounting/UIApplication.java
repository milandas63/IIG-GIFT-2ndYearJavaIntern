package Project_Stock_Accounting;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Project_Stock_Accounting.ProductMaintenance;

public class UIApplication extends JFrame {
	public UIApplication() {
		this.setTitle("Stock Accounting");
		this.setIconImage(new ImageIcon("icon.png").getImage());
		this.setLayout(new BorderLayout());
		
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
						new ProductMaintenance();
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
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(50,50,1200,650);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new UIApplication();
	}

}
