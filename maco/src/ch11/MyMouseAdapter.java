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
	ArrayList<Point> points = null;//集合类 使用泛型
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

class Moniter4 extends MouseAdapter{//继承MouseAdapter而非实现MouseListener接口是因为ml中含有多个方法，
	public void mousePressed(MouseEvent e){//这两种都行
	/*public void mouseClicked(MouseEvent e){*///需要都给予实现（即使是只写一些空的方法），而我们只需要其中的几个，这样就会很麻烦,MouseAdapter
		PFrame2 pf =  (PFrame2)(e.getSource());//已经帮我们实现了ml中的所有方法，所以我们只需要将自己需要的方法重写一遍就可以，这样就会简便
		pf.addPoint(new Point(e.getX(), e.getY()));
		pf.repaint();//没有这句话就显示不出来那些点，repaint先调用update，再调用paint
	 }
	                              
	
}