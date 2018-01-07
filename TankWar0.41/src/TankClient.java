import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*坦克动起来的时候有闪烁现象，用双缓冲消除闪烁现象*/

public class TankClient extends Frame{
	public static void main(String[] args){
		TankClient tc = new TankClient();
		tc.launchFrame();
	}
	public void launchFrame(){
		setTitle("TankWar");
		setBounds(100, 100, 800, 600);
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
	}
	int a = 50, b = 50;
	public void paint(Graphics g){
		//int a = 50, b = 50;写在这里不对哦
		Color c = g.getColor();
		
		g.setColor(Color.red);
		g.fillOval(a, b, 30, 30);
		
		g.setColor(c);
		
	    b += 50;
	}
	Image offScreamImage = null;
	public void update(Graphics g){
		if(offScreamImage == null){
			offScreamImage = this.createImage(800, 600);
		}
		Graphics goffScream = offScreamImage.getGraphics();//拿到背面的画笔
		
		Color c = goffScream.getColor();
		goffScream.setColor(Color.green);
		goffScream.fillRect(0, 0, 800, 600);
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
}
