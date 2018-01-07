package ch7;

import java.util.*;

public class Test {
	public static void main(String[] args){
		Collection c = new ArrayList();
		
		c.add("Hello");
		c.add(new Name("f1", "l1"));
		c.add(new Integer(100));
		c.add(new Name("f1", "l1"));
		
		System.out.println(c.size());
		System.out.println(c);
		
	}
	
}


class Name{
	private String first, last;
	public Name(String first, String last){
		this.first = first;
		this.last = last;
	}
	public String getFirst(){
		return first;
	}
	public String getLast(){
		return last;
	}
	public String toString(){
		return first + " " + last;		
	}
	
}