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
				out.write( b);//����Ϊʲô����TestFileInputStream.javaһ����Ҫ��char��b��
			}//Ϊʲô�ڸ��Ƶ��Ǹ��ļ����溺�ֲ���TestFileInputStream.javaһ������ʺţ�
			in.close();
			out.close();
		}catch(FileNotFoundException e){
			System.out.println("û���ҵ�ָ���ļ�");
			System.exit(-1);
		}catch(IOException e2){
			System.out.println("�ļ����ƴ���");
			System.exit(-1);
		}
		System.out.println("�ļ��������");
	}

}
