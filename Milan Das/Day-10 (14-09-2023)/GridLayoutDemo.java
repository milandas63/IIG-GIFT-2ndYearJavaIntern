package com.day10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GridLayoutDemo extends JFrame {
	public GridLayoutDemo() {
		this.setLayout(new BorderLayout());
		
		JLabel lblNorth = new JLabel("NORTH", JLabel.CENTER);
		JLabel lblWest = new JLabel("WEST", JLabel.CENTER);
		JPanel pnlCenter = new JPanel(new GridLayout(6,7));
		JLabel lblEast = new JLabel("EAST", JLabel.CENTER);
		JLabel lblSouth = new JLabel("SOUTH", JLabel.CENTER);

		lblNorth.setBackground(new Color(255,0,0));
		lblWest.setBackground(new Color(0,255,0));
		lblEast.setBackground(new Color(100,111,0));
		lblSouth.setBackground(new Color(0,255,255));
		
		lblNorth.setOpaque(true);
		lblWest.setOpaque(true);
		lblEast.setOpaque(true);
		lblSouth.setOpaque(true);

		String days[] = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		JButton btnDummy;
		for(int i=0; i<days.length; i++) {
			btnDummy = new JButton(days[i]);
			pnlCenter.add(btnDummy);
		}
		for(int i=1; i<=31; i++) {
			btnDummy = new JButton(String.valueOf(i));
			pnlCenter.add(btnDummy);
		}
		
		this.add(lblNorth, BorderLayout.NORTH);
		this.add(lblWest, BorderLayout.WEST);
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(lblEast, BorderLayout.EAST);
		this.add(lblSouth, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200,150,600,450);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutDemo();
	}
}
