package ch9;

public class TT2 implements Runnable{
	int b = 100;
	public synchronized void m1() throws Exception{
		b = 1000;
		Thread.sleep(5000);
		System.out.println("b=" + b);
	}
	public /*synchronized*/ void m2() throws Exception{
		//b = 2000;//����synchronized��ʱ��Ϊʲôλ�ò�ͬ����᲻ͬ�����Ϊ1000
		Thread.sleep(2500);
		b = 2000;//���Ϊ2000
		//System.out.println(b);
	}
	public void run(){
		try{
			m1();
		}catch(Exception e){//����ʹInterruptedException������m1()����ᱨ��
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
