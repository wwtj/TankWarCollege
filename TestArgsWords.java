import java.util.*;

public class TestArgsWords{
	/* 
	//自动打包
	//private static final Integer ONE = new Integer(1);
	private static final int ONE = 1;

	public static void main(String[] args){
		Map m = new HashMap();
		for(int i=0;i<args.length;i++){
			//Integer freq = (Integer)m.get(args[i]);
			int freq = (Integer)m.get(args[i]) == null ? 0 :  (Integer)m.get(args[i]);//空值无法自动转换为int 0，所以写成这样子。
			//m.put(args[i], (freq == null ? ONE : new Integer(freq.intValue() + 1)));
			m.put(args[i], (freq == 0 ? ONE : freq + 1));
		}
		System.out.println(m.size() + " distinct woeds detected;");
		System.out.println(m);
	}*/ 

	//使用泛型
	
	private static final int ONE = 1;

	public static void main(String[] args){
		Map<String, Integer> m = new HashMap<String, Integer>();
		for(int i=0;i<args.length;i++){
			
			  int freq = m.get(args[i]) == null ? 0 :  m.get(args[i]);//空值无法自动转换为int 0，所以写成这样子。
			
			  m.put(args[i], (freq == 0 ? ONE : freq + 1));
		}
		System.out.println(m.size() + " distinct woeds detected;");
		System.out.println(m);
	}
}