package com.day10;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BorderLayoutDemo extends JFrame {
	public BorderLayoutDemo() {
		this.setLayout(new BorderLayout());
		
		JLabel lblNorth = new JLabel("NORTH", JLabel.CENTER);
		JLabel lblWest = new JLabel("WEST", JLabel.CENTER);
		JLabel lblCenter = new JLabel("CENTER", JLabel.CENTER);
		JLabel lblEast = new JLabel("EAST", JLabel.CENTER);
		JLabel lblSouth = new JLabel("SOUTH", JLabel.CENTER);

		lblNorth.setBackground(new Color(255,0,0));
		lblWest.setBackground(new Color(0,255,0));
		lblCenter.setBackground(new Color(0,0,255));
		lblEast.setBackground(new Color(100,111,0));
		lblSouth.setBackground(new Color(0,255,255));
		
		lblNorth.setOpaque(true);
		lblWest.setOpaque(true);
		lblCenter.setOpaque(true);
		lblEast.setOpaque(true);
		lblSouth.setOpaque(true);

		this.add(lblNorth, BorderLayout.NORTH);
		this.add(lblWest, BorderLayout.WEST);
		this.add(lblCenter, BorderLayout.CENTER);
		this.add(lblEast, BorderLayout.EAST);
		this.add(lblSouth, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200,150,600,450);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutDemo();
	}

}
