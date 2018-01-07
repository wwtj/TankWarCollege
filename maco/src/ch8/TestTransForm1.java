package ch8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TestTransForm1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			OutputStreamWriter osw = new OutputStreamWriter(
					new FileOutputStream("F:/ninteresting/maco/maco/src/ch8/TestTransForm12.txt"));
			osw.write("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			System.out.println(osw.getEncoding());
			osw.flush();
			osw.close();
			
			osw = new OutputStreamWriter(
					new FileOutputStream("F:/ninteresting/maco/maco/src/ch8/TestTransForm12.txt",true), 
					"ISO8859_1");
			osw.write("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
			System.out.println(osw.getEncoding());
			osw.flush();			
			osw.close();
			
		}catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
