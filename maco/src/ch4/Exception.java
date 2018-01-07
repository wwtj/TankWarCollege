package ch4;

public class Exception {
	public static void main (String args[]){
		int array[] = {1,2,3};
		for(int i=0;i<4;i++){
			try{
				System.out.println(array[i]);
			}catch(ArrayIndexOutOfBoundsException oe){
				System.out.println("系统出错，请与管理员联系。");
			}
		}
		try{
			int a = 2/0;
		}catch(ArithmeticException ae){
			System.out.println("系统出错，请与管理员联系2.");
			ae.printStackTrace();
		}
	}

}
