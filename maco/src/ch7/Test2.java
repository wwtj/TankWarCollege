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
		c.add(new Name3("f1", "l1"));//Ϊʲô�����ظ��أ�������Ϊ��Collection�ģ�Test3ֱ������ΪHash�Ͳ����ظ�
		
		Iterator i = c.iterator();
		
		while(i.hasNext()){
			Name3 name = (Name3)i.next();//next()�ķ���ֵ����ΪObject���ͣ�������Ҫת��Ϊ��Ӧ����
			System.out.println(name.getFirst());//�����Ӣ���еĵ��ǲ�һ���ģ�����ᱨ��
		}
		
		for(Iterator it = c.iterator();it.hasNext(); ){
			Name3 name = (Name3)it.next();
			if(name.getFirst().length() < 3){
				it.remove();
				//c.remove(name);������������⣬��Ϊ����ֱ�Ӷ��������в���
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