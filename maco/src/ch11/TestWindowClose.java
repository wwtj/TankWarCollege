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
		//�ڲ����ʱ����
		//addWindowListener(new CMoniter());
		//�ֲ��࣬�������ڲ��ࣨ�ڷ����ڲ���
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(false);
				System.exit(0);
			}
		});
	}
	/*
	class CMoniter extends WindowAdapter{//�ڲ���
		public void windowClosing(WindowEvent e){//����������ַ���һ��Ҫ����API��ϸд�����ƴ���ˣ������ᱨ�������Ҳ��������������
			setVisible(false);
			System.exit(0);
		}
	}*/
}