package ch11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestAnnoyMouse {
	Frame f = new Frame("testAnnouMouse");
	TextField tf = new TextField(10);
	Button b = new Button("start");
	
	public TestAnnoyMouse(){
		f.add(b, BorderLayout.NORTH);
		f.add(tf, BorderLayout.SOUTH);
		
		b.addActionListener(new ActionListener(){
			private int i = 0;
			public void actionPerformed(ActionEvent e){
				tf.setText(e.getActionCommand() + ++i);
			}
		});
		
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args){
		new TestAnnoyMouse();
	}
}
