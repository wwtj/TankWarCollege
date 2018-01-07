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
		while(index == arraymanto.length){//�˴�������if����Ϊ��if�Ļ���wait�˱���Ϻ������ifִ�к������䣬����ʱ��Ȼ�����ģ���ͻᱨ����while�Ļ�������Ժ��������while�е�����
			try{
				this.wait();//�����ڵ�ǰ�����ϵ�����߳�wait��ֻ���߳������˶�������ʸ�wait,һ��wait�ˣ����Ͳ�����߳������ˣ��ȱ���������������
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		this.notifyAll();//װ���ˣ��Ͻ��������߿���
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
		this.notifyAll();//����һ���������������wait�Ľ���.���û��������ѣ���ô��������������wait����������ȫ�����������Ժ�Ͳ����ٸ������������������Ǿ�ͣ�������ˣ��൱��һ������
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
			System.out.println("�����ˣ�" + mt);
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
			 System.out.println("�����ˣ�" + mt);
			 try{
					Thread.sleep((int)(Math.random() * 1000));
				}catch(InterruptedException e){
					e.printStackTrace();
				}
		}
	}
}