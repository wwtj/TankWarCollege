
public class AbRef {
	public static void main(String[] args){
		int i =10;
		int j = 20;
		
		int ref =i;
		ref = ref ++;
		System.out.println(ref);//10
		
		ref = j;
		ref = ++ref;
		System.out.println(ref);//21
		
		System.out.println(i);//10
		System.out.println(j);//20
	}
}
