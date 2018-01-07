package ch11;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TFActionEvent{
	public static void main(String[] args){
		new TFFrame();
	}
}

class TFFrame extends Frame{
	TFFrame(){
		TextField tf = new TextField();
		add(tf);
		pack();
		tf.setEchoChar('*');
		TFActionListener tfa = new TFActionListener();
		tf.addActionListener(tfa);
		setVisible(true);
	}
}

class TFActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		TextField tf = (TextField) e.getSource();//e.getSource()拿回来的是一个object的对象，所以要强制转换成TextField
		System.out.println(tf.getText());
		tf.setText("");
	}
}