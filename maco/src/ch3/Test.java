package ch3;


class person{
	private String  name;
	private String location;
	
	person(String name){
		this.name = name;
		this.location = "beijing";
	}
	person(String name, String location){
		this.name = name;
		this.location = location;
	}
	
	public String info(){
		return 
				"name: "+name+"   location: "+location;
	}
}

class student extends person{
	private String school;

	student(String name, String school) {
		this(name, "beijing", school);
	}
	student(String name, String location, String school) {
		super(name,location);
		this.school = school;
	}
	
	public String info(){
		return
				super.info() + "  school: "+school;
	}
	
}

class teacher extends person{
	private String capital;
	
	teacher(String name, String capital){
		this(name, "beijing", capital);
	}
	teacher(String name, String location, String capital){
		super(name, location);
		this.capital = capital;
	}
	
	public String info(){
		return super.info()+"  capital: "+capital;
	}
	
}

public class Test {
	public static void main(String args[]){
		person p1 = new person("A");
		person p2 = new person("B", "shanghai");
		student s1 = new student("C","shanda");
		student s2 = new student("D", "shandong", "haiyang");
		teacher t1 = new teacher("E", "professor");
		teacher t2 = new teacher("F", "shanxi", "professor");
		
		System.out.println(p1.info());
		System.out.println(p2.info());
		System.out.println(s1.info());
		System.out.println(s2.info());
		System.out.println(t1.info());
		System.out.println(t2.info());
	}

}
