package ch8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b = 0;
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try{
			in = new FileInputStream("F:/ninteresting/maco/maco/src/ch8/TestFileOutputStream.java");
			out = new FileOutputStream("F:/ninteresting/maco/maco/src/ch8/TestFileOutputStream2.java");
			while((b = in.read()) != -1){
				out.write( b);//这里为什么不像TestFileInputStream.java一样需要（char）b？
			}//为什么在复制的那个文件里面汉字不像TestFileInputStream.java一样变成问号？
			in.close();
			out.close();
		}catch(FileNotFoundException e){
			System.out.println("没有找到指定文件");
			System.exit(-1);
		}catch(IOException e2){
			System.out.println("文件复制错误");
			System.exit(-1);
		}
		System.out.println("文件复制完毕");
	}

}
