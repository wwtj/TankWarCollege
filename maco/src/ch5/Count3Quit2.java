package ch5;
//����������˼ά
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
		System.out.print(kc.first.id);//kid��idҲ��
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
	
	void add(){//Ĭ�ϼ���������λ��
		Kid k = new Kid();
		k.id = n;
		if(n <= 0){
			first = k;
			last = k;
			//k = first;����д�Ǵ���ģ�
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
			System.out.println("ԲȦ���Ѿ�û������");
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