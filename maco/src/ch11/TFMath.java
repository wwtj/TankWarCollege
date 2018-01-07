package ch11;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TFMath {
	public static void main(String[] args){
		new TFFrame2().launchFrame();
	}
}


class TFFrame2 extends Frame{
	TextField tf1, tf2, tf3;
	public void launchFrame(){
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(15);
		Label l = new Label("+");
		Button b = new Button("=");
		//b.addActionListener(new MyMoniter3(this));//监听器类写在外面的时候用
		b.addActionListener(new MyMoniter3());
		setLayout(new FlowLayout());
		add(tf1);
		add(l);
		add(tf2);
		add(b);
		add(tf3);
		pack();
		setVisible(true);
	}
	
	//内部类
	class MyMoniter3 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int n1 = Integer.parseInt(tf1.getText());
			int n2 = Integer.parseInt(tf2.getText());
			tf3.setText("" + (n1 + n2));
		}
	} 
}

/*class MyMoniter3 implements ActionListener{
	TFFrame2 tf = null;
	public MyMoniter3(TFFrame2 tf){//构造方法不带void哦
		this.tf = tf;
	}
	public void actionPerformed(ActionEvent e){
		int n1 = Integer.parseInt(tf.tf1.getText());
		int n2 = Integer.parseInt(tf.tf2.getText());
		tf.tf3.setText("" + (n1 + n2));
	}
}*/
