package ch3;

class Prepoint{
	double x,y,z;
	
	//构造函数
	Prepoint(double _x, double _y, double _z){
		x = _x;
		y = _y;
		z = _z;
	}
	
	//设定xyz的值
	void setX(double _x){
		x = _x;
	}
	void setY(double _y){
		y = _y;
	}
	void setZ(double _z){
		z = _z;
	}
	
	//获得到另一个点的距离
	double getDistance(Prepoint p){
		return (x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)+(z-p.z)*(z-p.z);
	}
	
}

public class Point {
	public static void main(String args[]){
		Prepoint p = new Prepoint(1.0,2.0,3.0);
		Prepoint p1 = new Prepoint(0.0,0.0,0.0);
		
		System.out.println(p.getDistance(p1));
		
		p.setX(2.0);
		System.out.println(p.getDistance(p1));
		
	}

}
