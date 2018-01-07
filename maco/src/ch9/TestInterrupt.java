package ch9;

import java.util.Date;

public class TestInterrupt {
	public static void main(String[] args){
		Runner2 r2 = new Runner2();
		Thread t = new Thread(r2);
		t.start();
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			
		}
		//t.interrupt();Ì«´Ö±©
		r2.flag = false;
	}
}

class Runner2 implements Runnable{
	boolean flag = true;
	public void run(){
		while(flag){
			System.out.println("Date:" + new Date());
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				return;
			}
		}
	}
}
