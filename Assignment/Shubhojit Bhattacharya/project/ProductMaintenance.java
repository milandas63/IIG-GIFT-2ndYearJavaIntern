package project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class ProductMaintenance {
	public Connection conn;
	
	public ProductMaintenance(JDesktopPane desktop, Connection conn) {
		this.conn = conn;

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
		iProduct.setBounds(0,0,desktop.getWidth(),desktop.getHeight()-1);
		iProduct.setVisible(true);
	}
}