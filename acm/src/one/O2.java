package one;

import java.util.Scanner;
import java.util.Stack;

public class O2 {
	public static void main(String[] args){
		System.out.println("�����봮�ĸ�����");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		
		while(a != 0){
			String str = scan.next();
			if(str.length()%2 == 1){
				System.out.println("No");
			}else {//�����ż������ʼ�����ַ���
				Stack<Character> s = new Stack<Character>();
				for(int j=0; j<str.length(); j++){
					if(s.isEmpty()){
						s.push(str.charAt(j));
					}else if((s.peek().equals('[') && str.charAt(j)==']') ||
							(s.peek().equals('(') && str.charAt(j)==')')){
						s.pop();
					}else{
						s.push(str.charAt(j));
					}
				}
				
				if(s.isEmpty()){
					System.out.println("Yes");
				}else{
					System.out.println("No");
				}
			}
			a--;
		}
	}
}