package ch5;

public class TwoArray {
	public static void main(String[] args){
		String[] s = {"a","b","c","d","e"};
		String[] sBak = new String[6];
		System.arraycopy(s,0,sBak,0,s.length);
		
		for(int i=0;i<sBak.length;i++){
			System.out.println(sBak[i]+" ");
		}
	}
}
