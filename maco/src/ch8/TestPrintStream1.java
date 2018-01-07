package ch8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestPrintStream1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintStream ps = null;
		try{
			FileOutputStream fos = new FileOutputStream("F:/ninteresting/maco/maco/src/ch8/TestPrintStream12.txt");
			ps = new PrintStream(fos);
		}catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
		if(ps != null){
			System.setOut(ps);
		}
		int ln = 0;
		for(int i=0;i <= 60000; i++){
			System.out.print(i + " ");
			ln ++;
			if(ln >= 100){
				System.out.println();
				ln = 0;
			}
		}
	}

}
