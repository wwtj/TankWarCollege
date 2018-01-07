package ch8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBufferStream2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("F:/ninteresting/maco/maco/src/ch8/TestBufferStream22.txt"));
			BufferedReader br = new BufferedReader(
					new FileReader("F:/ninteresting/maco/maco/src/ch8/TestBufferStream22.txt"));
			
			String s = null;
			for(int i=0;i<=100;i++){
				s = String.valueOf(Math.random());
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			System.out.println("写入成功");
			
			while((s = br.readLine()) != null){
				System.out.println(s);
			}
			System.out.println("读出成功");
			
			bw.close();
			br.close();
			
		/*}catch(FileNotFoundException e){
			System.out.println("无法找到指定的文件");
			System.exit(-1);*///不需要
		}catch(IOException e2){
			System.out.println("文件写入错误");
			System.exit(-1);
		}
	}

}
