package ch11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class TenButtons {
	public static void main(String[] args){
		Frame f = new Frame("TenButtons");
		f.setBounds(300, 300, 300, 400);
		f.setVisible(true);
		
		f.setLayout(new GridLayout(2, 1));
		Panel p1 = new Panel(new BorderLayout());
		Panel p2 = new Panel(new BorderLayout());
		f.add(p1);
		f.add(p2);
		
		//to p1
		Panel p11 = new Panel(new GridLayout(2, 1));
		p1.add(p11, BorderLayout.CENTER);
		p11.add(new Button("Button"));
		p11.add(new Button("Button"));
		
		p1.add(new Button("Button"), BorderLayout.WEST);
		p1.add(new Button("Button"), BorderLayout.EAST);
		
		//to p2
		Panel p21 = new Panel(new GridLayout(2, 2));
		p2.add(p21, BorderLayout.CENTER);
		for(int i=0; i<4; i++){
			p21.add(new Button("Button"));
		}
		
		p2.add(new Button("Button"), BorderLayout.WEST);
		p2.add(new Button("Button"), BorderLayout.EAST);
	}
}
