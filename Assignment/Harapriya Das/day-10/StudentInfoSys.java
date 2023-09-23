package com.day10;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentInfoSys extends JFrame {
	public JLabel lblID, lblName, lblFather, lblGender, lblEmail, lblPhone;
	public JTextField tfID, tfName, tfFather, tfEmail, tfPhone;
	public JRadioButton rbMale, rbFemale;
	public JButton btnSave, btnClear, btnExit;
	
	public StudentInfoSys() {
		this.setLayout(new BorderLayout());
		this.setTitle("Student Information System");
		
		// North
		this.add(new JLabel("Student Information System", JLabel.CENTER), BorderLayout.NORTH);
		
		//	East
		JPanel pnlLabel = new JPanel(new GridLayout(10,1));
		this.add(pnlLabel, BorderLayout.WEST);
			lblID = new JLabel("ID: ", JLabel.RIGHT);
			lblName = new JLabel("Name: ", JLabel.RIGHT);
			lblFather = new JLabel("Father's Name: ", JLabel.RIGHT);
			lblGender = new JLabel("Gender: ", JLabel.RIGHT);
			lblEmail = new JLabel("Email-id: ", JLabel.RIGHT);
			lblPhone = new JLabel("Mobile No.: ", JLabel.RIGHT);
			
			pnlLabel.add(new JLabel(""));
			pnlLabel.add(new JLabel(""));
			pnlLabel.add(lblID);
			pnlLabel.add(lblName);
			pnlLabel.add(lblFather);
			pnlLabel.add(lblGender);
			pnlLabel.add(lblEmail);
			pnlLabel.add(lblPhone);
			pnlLabel.add(new JLabel(""));
			pnlLabel.add(new JLabel(""));

		//	Center
		JPanel pnlField = new JPanel(new GridLayout(10,1));
		this.add(pnlField, BorderLayout.CENTER);
			tfID = new JTextField();
			tfName = new JTextField();
			tfFather = new JTextField();
			tfEmail = new JTextField();
			tfPhone = new JTextField();

			pnlField.add(new JLabel(""));
			pnlField.add(new JLabel(""));
			pnlField.add(tfID);
			pnlField.add(tfName);
			pnlField.add(tfFather);
			pnlField.add(new JLabel());
			pnlField.add(tfEmail);
			pnlField.add(tfPhone);
			pnlField.add(new JLabel(""));
			pnlField.add(new JLabel(""));
		
		// South
		JPanel pnlButton = new JPanel(new GridLayout(1,7));
		this.add(pnlButton, BorderLayout.SOUTH);
			btnSave = new JButton(" Save ");
			btnClear = new JButton(" Clear ");
			btnExit = new JButton(" Exit ");

			pnlButton.add(new JLabel(""));
			pnlButton.add(new JLabel(""));
			pnlButton.add(btnSave);
			pnlButton.add(btnClear);
			pnlButton.add(btnExit);
			pnlButton.add(new JLabel(""));
			pnlButton.add(new JLabel(""));
			
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200,150,600,450);
		this.setVisible(true);
	}

	@Override
	public Insets getInsets() {
		Insets inset = new Insets(0,25,15,25);
		return inset;
	}
	
	public static void main(String[] args) {
		new StudentInfoSys();
	}

}
