package ch3;

interface CarePet{
	public void feed();
	public void play();
}

class Gongren implements CarePet{
	private String name;
	Gongren(String name){
		this.name = name;
	}
	public void feed(){
		System.out.println("Gongren feed.");
	}
	public void play(){
		System.out.println("Gongren play.");
	}
}
class Nongmin implements CarePet{
	private String name;
	Nongmin(String name){
		this.name = name;
	}
	public void feed(){
		System.out.println("Nongmin feed.");
	}
	public void play(){
		System.out.println("Nongmin play.");
	}
}
class Guojiaganbu implements CarePet{
	private String name;
	Guojiaganbu(String name){
		this.name = name;
	}
	public void feed(){
		System.out.println("Guojiaganbu feed.");
	}
	public void play(){
		System.out.println("Guojiaganbu play.");
	}
}

public class InterfaceExercise {
	public static void main(String args[]){
		Gongren gon1 = new Gongren("gongren"); 
		gon1.feed();
		gon1.play();
		
		Nongmin nong1 = new Nongmin("nongmin"); 
		nong1.feed();
		nong1.play();
		
		Guojiaganbu guo1 = new Guojiaganbu("guojiaganbu"); 
		guo1.feed();
		guo1.play();
	}

}
