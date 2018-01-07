package ch9;

public class TT2 implements Runnable{
	int b = 100;
	public synchronized void m1() throws Exception{
		b = 1000;
		Thread.sleep(5000);
		System.out.println("b=" + b);
	}
	public /*synchronized*/ void m2() throws Exception{
		//b = 2000;//不加synchronized的时候为什么位置不同结果会不同？结果为1000
		Thread.sleep(2500);
		b = 2000;//结果为2000
		//System.out.println(b);
	}
	public void run(){
		try{
			m1();
		}catch(Exception e){//不能使InterruptedException，否则m1()那里会报错
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception{
		TT2 tt = new TT2();
		Thread t = new Thread(tt);
		t.start();
		
		tt.m2();  
		System.out.println(tt.b);
	}
}
