package ch7;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test6 {

	public static void main(String[] args) {
		Map<String, Integer> m1 = new HashMap<String, Integer>();//尖括号：泛型
		Map<String, Integer> m2 = new TreeMap<String, Integer>();
		
		//自动打包和解包
		//m1.put("one", new Integer(100));
		m1.put("one", 100);
		//m1.put("two", new Integer(200));
		m1.put("two", 200);
		//m1.put("three", new Integer(300));
		m1.put("three", 300);
		
		//m2.put("A", new Integer(100));
		m2.put("A", 100);
		//m2.put("B", new Integer(200));
		m2.put("B", 200);
		
		System.out.println(m1.size());
		System.out.println(m1.containsKey("one"));
		System.out.println(m1.containsKey("four"));
		//System.out.println(m2.containsValue(new Integer(100)));
		System.out.println(m2.containsValue(100));
		if(m2.containsKey("B")){
			//int i = ((Integer)m2.get("B")).intValue();
			//int i = (Integer)m2.get("B");//自动打包、解包
			int i = m2.get("B");
			System.out.println(i);
		}
		
		Map m3 = new HashMap(m1);
		m3.putAll(m2);
		System.out.println(m3);
	}

}
