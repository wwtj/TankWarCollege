package ch9;

public class TestSyn implements Runnable {
	Timer timer = new Timer();
	public static void main(String[] args){
		TestSyn test = new TestSyn();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}
	public void run(){
		timer.add(Thread.currentThread().getName());
	}
}

/*class Timer{	
	public static int num = 0;
	public synchronized void add(String name){
		num ++;
		try{
			Thread.sleep(1);
		}catch(InterruptedException e){
			return;
		}
		System.out.println(name + ", 你是第" + num + "个使用timer的线程");
	}
}*/

class Timer{	
	public static int num = 0;
	public void add(String name){
		synchronized(this){//互斥锁
			num ++;
			try{
				Thread.sleep(1);
			}catch(InterruptedException e){
				return;
			}
			System.out.println(name + ", 你是第" + num + "个使用timer的线程");
		}
	}
}