package ch11;

import java.awt.Color;
import java.awt.Frame;

public class TestFrame {
	public static void main(String[] args){
		Frame f = new Frame("My first test.");
		f.setLocation(300,300);
		f.setSize(200, 100);
		f.setBackground(Color.green);
		f.setResizable(true);
		f.setVisible(true);
	}
}
