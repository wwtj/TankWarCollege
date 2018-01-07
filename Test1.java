public class Test1{
	public static void main (String args[]){
		int i=1;
		int num=0;
		while(i<=100){
			if(i%3==0){
				System.out.print(i+" ");
				num++;
				if(num>5)
					break;
			}
			i++;
		}
	}
}