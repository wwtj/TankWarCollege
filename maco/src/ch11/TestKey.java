package ch11;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestKey {
	public static void main(String[] args){
		new KFrame("test1");
	}
}

class KFrame extends Frame{
	KFrame(String s ){
		super(s);
		setBounds(100, 100, 300, 200);
		setBackground(Color.blue);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(false);
				System.exit(0);
			}
		});
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_UP){
					System.out.println("up");
				}
			}
		});
	}
	
}