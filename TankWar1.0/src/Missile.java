import java.awt.Color;
import java.awt.Graphics;


public class Missile {
	public static final int XSPEED = 10, YSPEED = 10;
	int x, y;
	Tank.Direction dir;
	Missile(int x, int y, Tank.Direction dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.black);
		g.fillOval(x, y, 10, 10);
		g.setColor(c);
		
		move();
	}

	private void move() {
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
		}
	}
}
