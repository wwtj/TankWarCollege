package ch11;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

public class TestFlowLayout {
	public static void main(String[] args){
		Frame f = new Frame("testFlowLayout");
		f.setSize(300, 300);
		f.setBackground(Color.green);
		f.setResizable(true);
		f.setVisible(true);
		
		Button b1 = new Button("ok");
		Button b2 = new Button("yes");
		Button b3 = new Button("no");
		
		f.setLayout(new FlowLayout(FlowLayout.LEFT));
		f.add(b1);
		f.add(b2);
		f.add(b3);
	}
}
