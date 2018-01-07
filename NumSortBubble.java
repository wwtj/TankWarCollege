public class NumSortBubble{
	public static void main (String[] args){
		int[] a = new int[args.length];
		for(int i=0;i<args.length;i++){
			a[i] = Integer.parseInt(args[i]);
		}
		
		print(a);
		bubbleSort(a);
		print(a);
		
	}
	

	private static void print(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	private static void bubbleSort(int[] a){
		int temp;
		for(int i=a.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(a[i]<a[j]){
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;	
				}
			}
		}
	}
}