import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;


public class Tank {

	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	
	private static Random r = new Random();
	
	private int x, y;
	enum Direction {L, LU, U, RU, R, RD, D, LD, STOP};
	private Direction dir = Direction.STOP;
	private Direction ptDir = Direction.D;
	boolean bL = false, bU = false, bR = false, bD = false;
	
	TankClient tc = null;
	
	private boolean good;
	public boolean isGood() {
		return good;
	}
	
	private boolean live = true;
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
	private int life = 100;
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	
	int oldX, oldY;
	public Tank(int x, int y, boolean good) {
		this.x = x;
		this.y = y;
		this.oldX = x;
		this.oldY = y;
		this.good = good;
	}
	public Tank(int x, int y, boolean good, Direction dir, TankClient tc){
		this(x, y, good);
		this.dir = dir;
		this.tc = tc;
	}
	
	private BloodBar bb = new BloodBar();
	public void draw(Graphics g){
		if(!live){
			if(!good){
				tc.enemyTanks.remove(this);
			}
			return;
		}
        Color c = g.getColor();
        if(good == true){
        	g.setColor(Color.red);
        }else{
        	g.setColor(Color.blue);
        }
		g.fillOval(x, y, WIDTH, HEIGHT);	
		g.setColor(c);
		move();
		//画炮筒
		if(dir != Direction.STOP){
			this.ptDir = this.dir;
		}
		switch(ptDir){
		case L :
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT/2, x, y +Tank.HEIGHT/2);
			break;
		case LU :
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT/2, x, y);
			break;
		case U :
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT/2, x + Tank.WIDTH/2, y);
			break;
		case RU :
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT/2, x + Tank.WIDTH, y);
			break;
		case R :
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT/2, x + Tank.WIDTH, y + Tank.HEIGHT/2);
			break;
		case RD :
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT/2, x + Tank.WIDTH, y + Tank.HEIGHT);
			break;
		case D :
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT/2, x + Tank.WIDTH/2, y + Tank.HEIGHT);
			break;
		case LD :
			g.drawLine(x + Tank.WIDTH/2, y + Tank.HEIGHT/2, x, y + Tank.HEIGHT);
			break;
		}
		if(good == true){
			bb.draw(g);
		}
	}
	
	private int step = r.nextInt(12) + 3;
	public void move(){
		oldX = x;
		oldY = y;
		
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
		if(x < 0) {
			x = 0;
		}
		if(x > (TankClient.GAME_WIDTH - Tank.WIDTH)){
			x = TankClient.GAME_WIDTH - Tank.WIDTH;
		}
		if(y < 30){
			y = 30;
		}
		if(y > TankClient.GAME_HEIGHT - Tank.HEIGHT){
			y = TankClient.GAME_HEIGHT - Tank.HEIGHT;
		}
		if(!good){
			Direction[] dirs = Direction.values();//转换为数组
			if(step == 0){
				int rn = r.nextInt(dirs.length);
				step = r.nextInt(12) + 3;
				dir = dirs[rn];
			}
		    step--;
		    if(r.nextInt(40)>38) fire();
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
	public Missile fire() {
		if(!live){
			return null;
		}
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y, ptDir, good, tc);
		tc.missiles.add(m);
		return m;
		
	}
	public Missile fire(Direction dir) {
		if(!live){
			return null;
		}
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y, dir, good, tc);
		tc.missiles.add(m);
		return m;
	}
	public void superFire(){
		Direction[] dirs = Direction.values();
		for(int i=0; i<8; i++){//这里要写<8而不是<dirs.length,因为dirs.length中包含那个stop，就会有子弹停在屏幕中
			fire(dirs[i]);
		}
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
		case KeyEvent.VK_CONTROL :
			fire();
			break;
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
		case KeyEvent.VK_A :
			superFire();
			break;
		}
		locationDir();
	}
	public Rectangle getRect(){
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	public void stay(){
		x = oldX;
		y = oldY;
	}
	public boolean collidesWithWall(Wall w){
		if(this.live && this.getRect().intersects(w.getRect())){
			stay();
			return true;
		}
		return false;
	}
	public boolean collidesWithTanks(List<Tank> enemyTanks){
		for(int i=0; i<enemyTanks.size(); i++){
			Tank enemyTank = enemyTanks.get(i);
			if(this != enemyTank){//要判断一下自己是不是和自己相交，如果不判断，自己与自己一直相交，就一直保持上一个位置，就会一直不动，一直在原地改变方向打来打去
				if(this.live && enemyTank.isLive() && this.getRect().intersects(enemyTank.getRect())){
					stay();
					return true;
				}
			}
		}
		return false;
	}
	private class BloodBar{
		public void draw(Graphics g){
			Color c = g.getColor();
			g.setColor(Color.red);
			g.drawRect(x, y - 10, WIDTH, 10);
			g.fillRect(x, y - 10, WIDTH * life / 100, 10);
			g.setColor(c);
		}
	}
}
