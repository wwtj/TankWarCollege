package ch7;

import java.util.HashSet;
import java.util.Set;


public class Test3 {
	public static void main(String[] args){
		Set s = new HashSet();
		
		s.add("Hello");
		s.add(new Name2("f1", "f2"));
		s.add(new Integer(100));
		s.add("Hello");
		s.add(new Name2("f1", "f2"));//相同的元素不会被加入
		
		System.out.println(s);
	}
}
