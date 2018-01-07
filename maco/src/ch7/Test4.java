package ch7;

import java.util.HashSet;
import java.util.Set;

public class Test4 {

	public static void main(String[] args) {
		Set s1 = new HashSet();
		Set s2 = new HashSet();
		
		s1.add("a");
		s1.add("b");
		s1.add("c");
		
		s2.add("a");
		s2.add("d");
		s2.add("e");
		
		Set sn = new HashSet(s1);
		sn.retainAll(s2);
		System.out.println(sn);
		
		Set su = new HashSet(s1);
		su.addAll(s2);
		System.out.println(su);

	}

}
