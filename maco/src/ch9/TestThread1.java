package ch9;

public class TestThread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner1 r1 = new Runner1();
		//ͨ��thread��start�������߳�����
		Thread t = new Thread(r1);
		t.start();
		//��������
		//r1.run();
		
		for(int i=0; i <= 100; i ++){
			System.out.println("main--------" + i);
		}
	}
}

class Runner1 implements Runnable{
	public void run(){
		for(int i=0; i <= 100; i ++){
			System.out.println("Runner1:" + i);
		}
	}
}
