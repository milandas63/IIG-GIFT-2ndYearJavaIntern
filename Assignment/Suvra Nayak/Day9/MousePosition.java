package com.day9;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class MousePosition extends JFrame {
	public MousePosition() {
		super("Mouse Location");

		
		this.addMouseMotionListener(new MotionClass());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,75,1200,650);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MousePosition();
	}
}

class MotionClass implements MouseMotionListener {
	int x;
	int y;
	String pos;

	@Override
	public void mouseDragged(MouseEvent me) {
		x = me.getX();
		y = me.getY();
		pos = x+"/"+y;
		me.getComponent().getGraphics().clearRect(x-10, y-10, 70, 70);
		me.getComponent().getGraphics().drawString(pos, x, y);
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		x = me.getX();
		y = me.getY();
		pos = x+"/"+y;
		me.getComponent().getGraphics().clearRect(x-10, y-10, 70, 70);
		me.getComponent().getGraphics().drawString(pos, x, y);
	}
}
