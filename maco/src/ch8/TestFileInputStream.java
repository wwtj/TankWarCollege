package ch8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.*;

public class TestFileInputStream {

	public static void main(String[] args) {
		FileInputStream in = null;
		int b = 0;
		
		try{
			in = new FileInputStream("F:/ninteresting/maco/maco/src/ch8/TestFileInputStream.java");
		}catch(FileNotFoundException e){
			System.out.println("找不到指定文件");
			System.exit(-1);
		}
		
		try{
			long num = 0;
			while((b = in.read()) != -1){
				System.out.print((char)b);
				num ++;
			}
			in.close();
			System.out.println();
			System.out.println("共读取了" + num + "个字节");
		}catch(IOException i){
			System.out.println("文件读取错误");
			System.exit(-1);
		}

	}

}
