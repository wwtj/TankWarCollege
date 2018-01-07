import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Tank {
	int a, b;
	public Tank(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public void draw(Graphics g){
        Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(a, b, 30, 30);	
		g.setColor(c);
	}
	public void keyPressed(KeyEvent e){
		int keyValue = e.getKeyCode();
		switch(keyValue){
		case KeyEvent.VK_LEFT :
			a -= 5;
			break;
		case KeyEvent.VK_UP :
			b -= 5;
			break;
		case KeyEvent.VK_RIGHT :
			a += 5;
			break;
		case KeyEvent.VK_DOWN :
			b += 5;
			break;
		}
	}
}
