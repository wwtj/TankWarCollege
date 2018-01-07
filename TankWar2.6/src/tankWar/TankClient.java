package tankWar;
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

/**
 * ��Ϸ��������
 * @author ���콿
 *
 */

public class TankClient extends Frame{
	/**
	 * ����̹����Ϸ�Ŀ��
	 */
	public static final int GAME_WIDTH = 800;
	/**
	 * ����̹����Ϸ�ĸ߶�
	 */
	public static final int GAME_HEIGHT = 600;
	
	Tank myTank = new Tank(50, 50, true, Tank.Direction.STOP, this);
	Wall w1 = new Wall(100, 200, 40, 150, this);
	Wall w2 = new Wall(300, 100, 300, 40, this);
	Blood b = new Blood();
	
	List<Tank> enemyTanks = new ArrayList<Tank>();
	List<Missile> missiles = new ArrayList<Missile>();
	List<Explode> explodes = new ArrayList<Explode>();
	public static void main(String[] args){
		TankClient tc = new TankClient();
		tc.launchFrame();
	}
	/**
	 * ��������ʾ̹��������
	 */
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
		
		for(int i=0; i<10; i++){
			Tank enemyTank = new Tank(50 + 50*(i+1), 60, false, Tank.Direction.D, this);
			enemyTanks.add(enemyTank);
		}
	}
	
	public void paint(Graphics g){	
		g.drawString("myTank life: " + myTank.getLife(), 10, 110);
		myTank.draw(g);
		myTank.eat(b);
		
		if(enemyTanks.size()<=0){
			for(int i=0; i<5; i++){
				Tank enemyTank = new Tank(50 + 50*(i+1), 60, false, Tank.Direction.D, this);
				enemyTanks.add(enemyTank);
			}
		}
		g.drawString("enemyTank count: " + enemyTanks.size(), 10, 90);
		for(int i=0; i<enemyTanks.size(); i++){
			if(enemyTanks.get(i) !=null){
				Tank enemyTank = enemyTanks.get(i);
				enemyTank.collidesWithWall(w1);
				enemyTank.collidesWithWall(w2);
				enemyTank.collidesWithTanks(enemyTanks);
				enemyTank.draw(g);
			}
		}
		
		g.drawString("missiles count: " + missiles.size(), 10, 50);
		for(int i=0; i<missiles.size(); i++){
			Missile m = missiles.get(i);
			m.hitTank(enemyTanks);
			m.hitTank(myTank);
			m.collidesWithWall(w1);
			m.collidesWithWall(w2);
			m.draw(g);
		}
		
		g.drawString("mexplodes count: " + explodes.size(), 10, 70);
		for(int i=0; i<explodes.size(); i++){
			Explode e = explodes.get(i);
			e.draw(g);
		}
		
		w1.draw(g);
		w2.draw(g);
		
		b.draw(g);
	}
	Image offScreamImage = null;
	public void update(Graphics g){
		if(offScreamImage == null){
			offScreamImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics goffScream = offScreamImage.getGraphics();//�õ�����Ļ���
		
		Color c = goffScream.getColor();
		goffScream.setColor(Color.green);
		goffScream.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		goffScream.setColor(c);
		
		paint(goffScream);//�ú���Ļ��ʻ���Բ
		g.drawImage(offScreamImage, 0, 0, null);//��ǰ��Ļ��ʽ�ͼƬ������
	}
	
	private class PaintThread implements Runnable{
		public void run(){
			while(true){
				repaint();//�����ⲿ��װ���repaint����
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
