package ch11;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class CenterPanel {
	public static void main(String[] args){
		new MyFrame(300, 300, 400, 300, Color.blue);
	}
}


class MyFrame extends Frame{
	private Panel p;
	MyFrame(int a, int b, int c, int d, Color co){
		super("FrameWithPanel");
		setLayout(null);
		setBounds(a, b, c, d);
		setBackground(co);
		setVisible(true);
		
		p = new Panel(null);
		p.setBounds(c/4, d/4, c/2, d/2);
		p.setBackground(Color.yellow);
		add(p);
		
	}
}