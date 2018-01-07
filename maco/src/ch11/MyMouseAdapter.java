package ch11;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class MyMouseAdapter {
	public static void main(String[] args){
		new PFrame2("dian");
	}
}

class PFrame2 extends Frame{
	ArrayList<Point> points = null;//������ ʹ�÷���
	PFrame2(String s){
		super(s);
		points = new ArrayList<Point>();
		setBounds(100, 100, 300, 200);
		setBackground(Color.green);
		setVisible(true);
		addMouseListener(new Moniter4());
	}
	public void paint(Graphics g){
		Color c = g.getColor();
		
		g.setColor(Color.yellow);
		Iterator<Point> i = points.iterator();
		while(i.hasNext()){
			Point p = (Point)(i.next());
			g.fillOval(p.x, p.y, 10, 10);
		}
	}
	public void addPoint(Point p){
		points.add(p);
	}
}

class Moniter4 extends MouseAdapter{//�̳�MouseAdapter����ʵ��MouseListener�ӿ�����Ϊml�к��ж��������
	public void mousePressed(MouseEvent e){//�����ֶ���
	/*public void mouseClicked(MouseEvent e){*///��Ҫ������ʵ�֣���ʹ��ֻдһЩ�յķ�������������ֻ��Ҫ���еļ����������ͻ���鷳,MouseAdapter
		PFrame2 pf =  (PFrame2)(e.getSource());//�Ѿ�������ʵ����ml�е����з�������������ֻ��Ҫ���Լ���Ҫ�ķ�����дһ��Ϳ��ԣ������ͻ���
		pf.addPoint(new Point(e.getX(), e.getY()));
		pf.repaint();//û����仰����ʾ��������Щ�㣬repaint�ȵ���update���ٵ���paint
	 }
	                              
	
}