package ch8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b = 0;
		FileReader re = null;
		
		try{
			long num = 0;
			re = new FileReader("F:/ninteresting/maco/maco/src/ch8/TestFileReader.java");
			while((b = re.read()) != -1){
				System.out.print((char)b);
				num ++;
			}
			System.out.println();
			System.out.println("����ȡ��" + num + "���ַ�");
			re.close();
		}catch(FileNotFoundException e){
			System.out.println("�޷��ҵ�ָ���ļ�");
			System.exit(-1);
		}catch(IOException e2){
			System.out.println("�ļ���ȡ����");
			System.exit(-1);
		}
	}

}
