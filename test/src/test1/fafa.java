package test1;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class fafa {

		public static void main(String[] args){
			new TFFrame().launchFrame();
		
	}
	

}

class TFFrame extends Frame{
	TextField tf1, tf2, tf3;
	public void launchFrame(){
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(15);
		Label l = new Label("+");
		Button b = new Button("=");
		b.addActionListener(new MyMoniter3(this));
		setLayout(new FlowLayout());
		add(tf1);
		add(l);
		add(tf2);
		add(b);
		add(tf3);
		pack();
		setVisible(true);
	}
	
}

class MyMoniter3 implements ActionListener{
	TFFrame tf = null;
	public MyMoniter3(TFFrame tf){//���췽������voidŶ
		this.tf = tf;
	}
	public void actionPerformed(ActionEvent e){
		int n1 = Integer.parseInt(tf.tf1.getText());
		int n2 = Integer.parseInt(tf.tf2.getText());
		tf.tf3.setText("" + (n1 + n2));
	}
}