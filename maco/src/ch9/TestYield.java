package ch9;

public class TestYield {
	public static void main(String[] args){
		MyThread2 mt2 = new MyThread2("t2");
		MyThread2 mt3 = new MyThread2("t3");
		mt2.start();
		mt3.start();
	}
}

class MyThread2 extends Thread{
	MyThread2(String s){
		super(s);
	}
	public void run(){
		for(int i=1; i <= 100; i++){
			System.out.println(getName() + ": " + i);
			if(i%10==0){
				yield();//到了10，但是并没有切换啊，怎么回事
			}
		}
	}
}