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
			System.out.println("�Ҳ���ָ���ļ�");
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
			System.out.println("����ȡ��" + num + "���ֽ�");
		}catch(IOException i){
			System.out.println("�ļ���ȡ����");
			System.exit(-1);
		}

	}

}
