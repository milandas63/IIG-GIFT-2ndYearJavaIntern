package com.day10;

import java.awt.FlowLayout;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo extends JFrame {
	String text = "India is a secular democratic nation There are around hundred forty crore people that live in this country";
	
	public FlowLayoutDemo() {
		JButton btnDummy;
		this.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
		StringTokenizer tokens = new StringTokenizer(text);
		while(tokens.hasMoreTokens()) {
			btnDummy = new JButton(tokens.nextToken());
			this.add(btnDummy);
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200,150,600,450);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FlowLayoutDemo();
	}

}
