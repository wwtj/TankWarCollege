package ch3;

interface singer{
	public void sing();
	public void sleep();
}
interface painter{
	public void paint();
	public void eat();
}

class stu implements singer{
	private String name;
	stu (String name){
		this.name = name;
	}
	public void study(){
		System.out.println("Student is studying");
	}
	public void sing(){
		System.out.println("Student is singing");
	}
	public void sleep(){
		System.out.println("Student is sleeping");
	}
}
class teacher2 implements singer,painter{
	private String name;
	teacher2(String name){
		this.name = name;
	}
	public void teach(){
		System.out.println("Teacher is teaching");
	}
	public void sing(){
		System.out.println("Teacher is singing");
	}
	public void sleep(){
		System.out.println("Teacher is sleeping");
	}
	public void paint(){
		System.out.println("Teacher is painting");
	}
	public void eat(){
		System.out.println("Teacher is eating");
	}
}

public class TestInterface {
	public static void main(String args[]){
		singer s1 = new stu("xiaoming");
		s1.sing();
		s1.sleep();
		
		painter p1 = new teacher2("wanglaoshi");
		p1.paint();
		p1.eat();
		
		singer s2 = (singer)p1;
		s2.sing();
		s2.sleep();
		
	    }
	void f(singer s){
    	s.sing();
	}

}
