package ch7;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Test2 {
	public static void main(String[] args){
		Collection c = new HashSet();
		
		//c.add(new Name3("f1", "l1"));
		c.add(new Name3("ffff2", "l2"));
		c.add(new Name3("f3", "l3"));
		c.add(new Name3("f1", "l1"));
		c.add(new Name3("f1", "l1"));//为什么可以重复呢？好像因为是Collection的，Test3直接声明为Hash就不能重复
		
		Iterator i = c.iterator();
		
		while(i.hasNext()){
			Name3 name = (Name3)i.next();//next()的返回值类型为Object类型，所以需要转换为相应类型
			System.out.println(name.getFirst());//汉语和英语中的点是不一样的，汉语会报错
		}
		
		for(Iterator it = c.iterator();it.hasNext(); ){
			Name3 name = (Name3)it.next();
			if(name.getFirst().length() < 3){
				it.remove();
				//c.remove(name);这样会产生例外，因为不能直接对容器进行操作
			}
		}
		System.out.println(c);
	}

}

class Name3{
	private String first, last;
	public Name3(String first, String last){
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