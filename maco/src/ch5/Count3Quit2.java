package ch5;
//用面向对象的思维
public class Count3Quit2 {
	public static void main(String[] args){
		KidCircle kc = new KidCircle(500);
		
		Kid kid = kc.first;
		
		int CountNum1 = 0;
		
		while(kc.n>1){
			
			CountNum1++;
			if(CountNum1 == 3){
				CountNum1 = 0;
				kc.delete(kid);
			}
			
			kid = kid.right;
		}
		System.out.print(kc.first.id);//kid。id也行
	}
}


class Kid{
	int id;
	Kid left,right;
}


class KidCircle{
	int n = 0;
	Kid first,last;
	
	KidCircle(int n){
		for(int i=0;i<n;i++){
			add();
		}
	}
	
	void add(){//默认加在最后面的位置
		Kid k = new Kid();
		k.id = n;
		if(n <= 0){
			first = k;
			last = k;
			//k = first;这样写是错误的！
			//k = last;
			k.right = k;
			k.left = k;
		}
		else{
			last.right = k;
			k.left = last;
			first.left = k;
			k.right = first;
			last = k;
		}
		n++;
	}
	
	void delete(Kid k){
		if (n<=0){
			System.out.println("圆圈上已经没有人了");
		}
		else if(n==1){
			last = first = null;
		}
		else {
			k.right.left = k.left;
		    k.left.right = k.right;
		    if(k == first){
				first = k.right;
			}
			else if(k == last){
				last = k.left;
			}
		}	
		n--;
	}
}