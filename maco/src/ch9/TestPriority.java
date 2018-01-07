package ch9;

public class TestPriority {
	public static void main(String[] args){
		Runner4 r1 = new Runner4();
		Runner3 r2 = new Runner3();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.setPriority(Thread.NORM_PRIORITY + 3);
		t1.start();
		t2.start();
	}
}

class Runner4 implements Runnable{
	public void run(){
		for(int i=0; i<=1000; i++){
			System.out.println("T1 " + i);
		}
	}
}

class Runner3 implements Runnable{
	public void run(){
		for(int i=0; i<=1000; i++){
			System.out.println("-------T2 " + i);
		}
	}
}