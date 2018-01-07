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
			System.out.println("共读取了" + num + "个字符");
			re.close();
		}catch(FileNotFoundException e){
			System.out.println("无法找到指定文件");
			System.exit(-1);
		}catch(IOException e2){
			System.out.println("文件读取出错");
			System.exit(-1);
		}
	}

}
