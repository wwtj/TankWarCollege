import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/*坦克出界*/

public class TankClient extends Frame{
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	Tank myTank = new Tank(50, 50, this);
	List<Missile> missiles = new ArrayList<Missile>();
	public static void main(String[] args){
		TankClient tc = new TankClient();
		tc.launchFrame();
	}
	
	public void launchFrame(){
		setTitle("TankWar");
		setBounds(100, 100, GAME_WIDTH, GAME_HEIGHT);
		setVisible(true);
		setBackground(Color.green);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}	
		});
		setResizable(false);
		/*PaintThread rt = new PaintThread();
		Thread t = new Thread(rt);
		t.start();*/
		new Thread(new PaintThread()).start();
		
		addKeyListener(new KeyMoniter());
	}
	
	public void paint(Graphics g){
	  g.drawString("missiles count: " + missiles.size(), 10, 50);
	  myTank.draw(g);
	  for(int i=0; i<missiles.size(); i++){
		  Missile m = missiles.get(i);
		  m.draw(g);
	  }
		
	}
	Image offScreamImage = null;
	public void update(Graphics g){
		if(offScreamImage == null){
			offScreamImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics goffScream = offScreamImage.getGraphics();//拿到背面的画笔
		
		Color c = goffScream.getColor();
		goffScream.setColor(Color.green);
		goffScream.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		goffScream.setColor(c);
		
		paint(goffScream);//用后面的画笔画出圆
		g.drawImage(offScreamImage, 0, 0, null);//用前面的画笔将图片画出来
	}
	
	private class PaintThread implements Runnable{
		public void run(){
			while(true){
				repaint();//调用外部包装类的repaint（）
			    try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private class KeyMoniter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}
		public void keyReleased(KeyEvent e){
			myTank.keyReleased(e);
		}
	}
}
