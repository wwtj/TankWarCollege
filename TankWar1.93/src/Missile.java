import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;


public class Missile {
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	private boolean live = true;
	
	private boolean good;
	
	int x, y;
	Tank.Direction dir;
	private TankClient tc;
	Missile(int x, int y, Tank.Direction dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	Missile(int x, int y, Tank.Direction dir, boolean good, TankClient tc){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.good = good;
		this.tc = tc;
	}
	
	public void draw(Graphics g){
		if( !live){
			tc.missiles.remove(this);
			return;
		}
		
		Color c = g.getColor(); 
		g.setColor(Color.black);
		g.fillOval(x, y, WIDTH, HEIGHT);
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
		if(x < 0 || y < 0 || x > TankClient.GAME_WIDTH || y > TankClient.GAME_HEIGHT){
			live = false;
			tc.missiles.remove(this);
		}
	}
	public Rectangle getRec(){
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	public boolean hitTank(Tank t){
		if(this.live && this.getRec().intersects(t.getRec()) && t.isLive() && this.good != t.isGood()){
			t.setLive(false);
			this.live = false;
			Explode e = new Explode(x, y, tc);
			tc.explodes.add(e);
			return true;
		}
		return false;
	}
	public boolean hitTank(List<Tank> enemyTanks){
		for(int i=0; i<enemyTanks.size(); i++){
			Tank enemyTank = enemyTanks.get(i);
			if(hitTank(enemyTank)){
				return true;
			}
		}
		return false;
	}
}
