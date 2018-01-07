package ch11;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionEvent2 {
	public static void main(String[] args){
		Frame f = new Frame("TestActionEvent2");
		f.setVisible(true);
		f.setLayout(new GridLayout(2, 1));
		
		Button b1 = new Button("start");
		Button b2 = new Button("stop");
		f.add(b1);
		f.add(b2);
		f.pack();
		
		Moniter2 m = new Moniter2();
		b1.addActionListener(m);
		b2.addActionListener(m);
		b2.setActionCommand("game over.");
	}
}

class Moniter2 implements ActionListener{
	public void actionPerformed(ActionEvent e){//接口里面所有方法都是public
		System.out.println("a button has been preshed, the relative info is: \n" + e.getActionCommand());
	}
}
