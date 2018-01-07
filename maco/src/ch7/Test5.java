package ch7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test5 {
	public static void main(String[] args){
		List l = new LinkedList();
		
		l.add(new Name2("Karl", "M"));
		l.add(new Name2("Steven", "Lee"));
		l.add(new Name2("John", "O"));
		l.add(new Name2("Tom", "M"));
		
		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);
		
	}
}
