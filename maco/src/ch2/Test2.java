package ch2;
//输出101~200内的质数
public class Test2 {
	public static void main(String args[]){
		for(int i=101;i<=200;i+=2){
			boolean flag =true;
			for(int j=2;j<i;j++){
				if(i%j==0){
					flag=false;
					break;
				}
			}
			if(!flag){
				continue;
			}
			System.out.print(" "+i);
		}
	}

}
