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

public class ManufacturerMaintenance {
	public Connection conn;
	
	public ManufacturerMaintenance(JDesktopPane desktop, Connection conn) {
		this.conn = conn;

		JInternalFrame iManufacturer = new JInternalFrame("Product");
		iManufacturer.setLayout(new BorderLayout(5,5));
		iManufacturer.setResizable(true);
		iManufacturer.setClosable(true);
		iManufacturer.setIconifiable(true);
		iManufacturer.setMaximizable(true);

		JPanel pnlBottom = new JPanel(new GridLayout(1,6));
		iManufacturer.add(pnlBottom, BorderLayout.SOUTH);
		JButton btnAdd = new JButton("Add");
		JButton btnEdit = new JButton("Edit");
		JButton btnDelete = new JButton("Delete");
		JButton btnSearch = new JButton("Search");
		JButton btnPrint = new JButton("Print");
		JButton btnExit = new JButton("Exit");
		JButton firstButton = new JButton("<<");
        JButton prevButton = new JButton("<");
        JButton nextButton = new JButton(">");
        JButton lastButton = new JButton(">>")
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iManufacturer.dispose();
			}
		});
		pnlBottom.add(firstButton);
		pnlBottom.add(prevButton);
		pnlBottom.add(nextButton);
		pnlBottom.add(lastButton);
		pnlBottom.add(btnAdd);
		pnlBottom.add(btnEdit);
		pnlBottom.add(btnDelete);
		pnlBottom.add(btnSearch);
		pnlBottom.add(btnPrint);
		pnlBottom.add(btnExit);
		
		desktop.add(iManufacturer);
		iManufacturer.setBounds(0,0,desktop.getWidth(),desktop.getHeight()-1);
		iManufacturer.setVisible(true);
	}
}