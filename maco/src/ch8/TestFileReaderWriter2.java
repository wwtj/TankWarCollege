package ch8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileReaderWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b = 0;
		FileReader re = null;
		FileWriter wr = null;
		
		try{
			re = new FileReader("F:/ninteresting/maco/maco/src/ch8/TestFileReaderWriter.java");
			wr = new FileWriter("F:/ninteresting/maco/maco/src/ch8/TestFileReaderWriter2.java");
			long num = 0;
			while((b = re.read()) != -1){
				wr.write((char)b);
				num ++;
			}
			System.out.println("��������" + num +"���ַ�");
			re.close();
			wr.close();
		}catch(FileNotFoundException e){
			System.out.println("�޷��ҵ��ƶ����ļ�");
			System.exit(-1);
		}catch(IOException e2){
			System.out.println("�ļ�����ʧ��");
			System.exit(-1);
		}
		System.out.println("�ļ����Ƴɹ�");
	}

}
