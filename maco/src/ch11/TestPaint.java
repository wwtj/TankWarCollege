package ch11;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class TestPaint {
	public static void main(String[] args){
		new PFrame().launchFrame();
	}
}

class PFrame extends Frame{
	public void launchFrame(){
		setBounds(300,300,200,150);
		setVisible(true);
	}
	public void paint(Graphics g){
		Color c = g.getColor();
		
		g.setColor(Color.red);
		g.fillOval(50, 50, 100, 75);
		g.setColor(Color.green);
		g.fillRect(100, 100, 50, 55);
		g.setColor(Color.blue);
		g.drawLine(0, 0, 500, 450);
		
		g.setColor(c);
	}
}