package ch9;

public class ProducerConsumer {
	public static void main(String[] args){
		TongStack tong = new TongStack();
		Producer p = new Producer(tong);
		Consumer c = new Consumer(tong);
		Thread tp1 = new Thread(p);
		tp1.start();
		Thread tp2 = new Thread(p);
		tp2.start();
		
		Thread tc1 = new Thread(c);
		//tc1.start();
		try{
			tc1.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		tc1.start();
	}
}

class Manto{
	int id;
	Manto(int id){
		this.id = id;
	}
	public String toString(){
		return "manto : " + id;
	}
}

class TongStack{
	int manTotal = 6;
	Manto[] arraymanto = new Manto[manTotal];
	int index = 0;
	
	public synchronized void push(Manto manto){ 
		while(index == arraymanto.length){//此处不能用if，因为用if的话，wait了被打断后会跳出if执行后面的语句，但此时仍然是满的，这就会报错。用while的话，打断以后会继续检查while中的条件
			try{
				this.wait();//锁定在当前对象上的这个线程wait，只有线程锁定了对象才有资格wait,一旦wait了，锁就不归此线程所有了，等被唤醒再重新找锁
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.notifyAll();//装满了，赶紧叫消费者快点吃
		arraymanto[index] = manto;
		index ++;
	}
	
	public synchronized Manto pop(){
		while(index == 0){
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.notifyAll();//叫醒一个正在这个对象上wait的进程.如果没有这个唤醒，那么生产者生产满了wait，消费者又全都消费完了以后就不会再告诉生产者生产，于是就停在那里了，相当于一种死锁
		index --;
		return arraymanto[index];
	}
}

class Producer implements Runnable{
	TongStack tong = null;
	Producer(TongStack tong){
		this.tong = tong;
	}
	public void run(){
		for(int i=0; i<10; i++){
			Manto mt = new Manto(i);
			tong.push(mt);
			System.out.println("生产了：" + mt);
			try{
				Thread.sleep((int)(Math.random() * 2));
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{
	TongStack tong = null;
	Consumer(TongStack tong){
		this.tong = tong;
	}
	public void run(){
		for(int i=0; i<20; i++){
			 Manto mt = tong.pop();
			 System.out.println("消费了：" + mt);
			 try{
					Thread.sleep((int)(Math.random() * 1000));
				}catch(InterruptedException e){
					e.printStackTrace();
				}
		}
	}
}