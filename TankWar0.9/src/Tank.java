import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Tank {
	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	private int x, y;
	enum Direction {L, LU, U, RU, R, RD, D, LD, STOP};
	private Direction dir = Direction.STOP;
	boolean bL = false, bU = false, bR = false, bD = false;
	
	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
        Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, 30, 30);	
		g.setColor(c);
		move();
	}
	public void move(){
		switch(dir){
		case L :
			x -= XSPEED;
			break;
		case LU :
			x -= XSPEED;
			y -= YSPEED;
			break;
		case U :
			y -= YSPEED;
			break;
		case RU :
			x += XSPEED;
			y -= YSPEED;
			break;
		case R :
			x += XSPEED;
			break;
		case RD :
			x += XSPEED;
			y += YSPEED;
			break;
		case D :
			y += YSPEED;
			break;
		case LD :
			x -= XSPEED;
			y += YSPEED;
			break;
		case STOP :
			break;
		
		}
	}
	//确定朝哪个方向走
	public void keyPressed(KeyEvent e){
		int keyValue = e.getKeyCode();
		switch(keyValue){
		case KeyEvent.VK_LEFT :
			bL = true;
			break;
		case KeyEvent.VK_UP :
			bU = true;
			break;
		case KeyEvent.VK_RIGHT :
			bR = true;
			break;
		case KeyEvent.VK_DOWN :
			bD = true;
			break;
		}
		locationDir();
	}
	public void locationDir(){
		if(bL & !bU & !bR & !bD) dir = Direction.L;
		else if(bL & bU & !bR & !bD) dir = Direction.LU;
		else if(!bL & bU & !bR & !bD) dir = Direction.U;
		else if(!bL & bU & bR & !bD) dir = Direction.RU;
		else if(!bL & !bU & bR & !bD) dir = Direction.R;
		else if(!bL & !bU & bR & bD) dir = Direction.RD;
		else if(!bL & !bU & !bR & bD) dir = Direction.D;
		else if(bL & !bU & !bR & bD) dir = Direction.LD;
		else if(!bL & !bU & !bR & !bD) dir = Direction.STOP;
	}

	public void keyReleased(KeyEvent e) {
		int keyValue = e.getKeyCode();
		switch(keyValue){
		case KeyEvent.VK_LEFT :
			bL = false;
			break;
		case KeyEvent.VK_UP :
			bU = false;
			break;
		case KeyEvent.VK_RIGHT :
			bR = false;
			break;
		case KeyEvent.VK_DOWN :
			bD = false;
			break;
		}
		locationDir();
		
	}
}
