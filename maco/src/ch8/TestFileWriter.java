package ch8;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter wr =null;
		
		try{
			wr = new FileWriter("F:/ninteresting/maco/maco/src/ch8/TestFileWriter2.java");
			//只能帮建文件，不能建目录
			for(int i=0; i<=50000;i++){
				wr.write(i);
			}
			wr.close();
		}catch(IOException e){
			System.out.println("文件写入出错");
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println("文件复制完毕");
	}

}
