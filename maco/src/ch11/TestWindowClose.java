package ch11;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindowClose {
	public static void main(String[] args){
		new CFrame("testClose");
	}
}

class CFrame extends Frame{
	CFrame(String s){
		super(s);
		setBounds(100, 100, 200, 300);
		setVisible(true);
		//内部类的时候用
		//addWindowListener(new CMoniter());
		//局部类，匿名的内部类（在方法内部）
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(false);
				System.exit(0);
			}
		});
	}
	/*
	class CMoniter extends WindowAdapter{//内部类
		public void windowClosing(WindowEvent e){//这里面的这种方法一定要对着API仔细写，如果拼错了，并不会报错，但是找不出来是哪里错了
			setVisible(false);
			System.exit(0);
		}
	}*/
}