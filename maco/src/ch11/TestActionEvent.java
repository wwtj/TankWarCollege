package ch11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionEvent {
	public static void main(String[] args){
		Frame f = new Frame("TestActionEvent");
		f.setBounds(100, 100, 200, 100);
		f.setVisible(true);
		Button b = new Button("ok");
		f.add(b, BorderLayout.CENTER);
		Moniter m = new Moniter();
		b.addActionListener(m);
		
	}
}

class Moniter implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.out.println("a button has been preshed.");
	}
}
