package ch5;

public class BinarySearch {
	public static void main(String[] args){
		int[] a = {1, 3, 4, 6, 8, 5, 0, 7, 9, 2};
		int n = 1;
		
		bubbleSort(a);
		System.out.println(binarySearch(a,n));
	}
	
	public static int binarySearch(int[] a, int n){
		if(a.length ==0){
			return -1;
		}
		
		int startPos = 0;
		int endPos = a.length-1;
		
		int m = (startPos + endPos) / 2;
		while(startPos <= endPos){
			if(n == a[m]){
				return m;
			}
			if(n > a[m]){
				startPos = m + 1;
			}
			if(n < a[m]){
				endPos = m - 1;
			}	
			m = (startPos + endPos) / 2;
		}
		return -1;
	}
	
	public static int[] bubbleSort(int[] a){
		int temp;
		for(int i=a.length-1; i>0; i--){
			for(int j=0; j<i; j++){
				if(a[i] < a[j]){
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
}
