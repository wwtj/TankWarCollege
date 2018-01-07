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

/*�ӵ�����̹��*/

public class TankClient extends Frame{
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	
	Tank myTank = new Tank(50, 50, true, Tank.Direction.STOP, this);
	
	List<Tank> enemyTanks = new ArrayList<Tank>();
	List<Missile> missiles = new ArrayList<Missile>();
	List<Explode> explodes = new ArrayList<Explode>();
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
		
		for(int i=0; i<10; i++){
			Tank enemyTank = new Tank(50 + 40*(i+1), 60, false, Tank.Direction.D, this);
			enemyTanks.add(enemyTank);
		}
	}
	
	public void paint(Graphics g){	
		myTank.draw(g);
		
		g.drawString("enemyTank count: " + enemyTanks.size(), 10, 90);
		for(int i=0; i<enemyTanks.size(); i++){
			if(enemyTanks.get(i) !=null){
				Tank enemyTank = enemyTanks.get(i);
				enemyTank.draw(g);
			}
		}
		
		g.drawString("missiles count: " + missiles.size(), 10, 50);
		for(int i=0; i<missiles.size(); i++){
			Missile m = missiles.get(i);
			m.hitTank(enemyTanks);
			m.draw(g);
		}
		
		g.drawString("mexplodes count: " + explodes.size(), 10, 70);
		for(int i=0; i<explodes.size(); i++){
			Explode e = explodes.get(i);
			e.draw(g);
		}
		
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
