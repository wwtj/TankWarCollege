package ch7;

import java.util.Collection;
import java.util.HashSet;

public class BasicContainer {
	public static void main(String[] args){
		Collection c = new HashSet();
		
		c.add("Hello");
		c.add(new Integer(100));
		c.add(new Name2("f1", "l1"));
		c.remove("Hello");
		System.out.println(c.contains(new Name2("f1", "l1")));
		System.out.println(c.remove(new Integer(100)));
		System.out.println(c.remove(new Name2("f1", "l1")));
		System.out.println(c);
	}
}

class Name2 implements Comparable{//�˴�ʵ��comparable�ӿ���Ϊ��Test5��ʵ������������
	private String first, last;
	public Name2(String first, String last){
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
	public boolean equals(Object obj){
		if(obj instanceof Name2){
			Name2 name = (Name2) obj;
			return (first.equals(name.first) && last.equals(name.last));
		}
		return super.equals(obj);
	}
	public int hashCode(){//ע���������û�в���
		return first.hashCode();
	}
	public int compareTo(Object o){//�˴�ʵ��comparable�ӿ���Ϊ��Test5��ʵ������������
		Name2 name = (Name2)o;
		int lastNum = last.compareTo(name.last);  
		return lastNum != 0 ? lastNum : first.compareTo(first);
	}
}
