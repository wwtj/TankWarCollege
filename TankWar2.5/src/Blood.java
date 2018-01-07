import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Blood {
	int x, y;
	int w = 15;
	int h = 15;
	
	private boolean live = true;
	public boolean getLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	
	private int[][] points = {
			{300, 300}, {310, 320}, {330, 340}, {350, 350}, {330, 340}, {310, 320}, {300, 300}
	};
	int step = 0;
	public void draw(Graphics g){
		if(this.getLive() == false){
			return;
		}
		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, w, h);
		g.setColor(c);
		
		move();
	}
	
	public void move(){
		if(step == points.length){
			step = 0;
		}
		x = points[step][0];
		y = points[step][1];
		step++;
	}
	
	public Rectangle getRect(){
		return new Rectangle(x, y, w, h);
	}
}
