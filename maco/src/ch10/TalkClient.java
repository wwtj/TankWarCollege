package ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkClient {
	public static void main(String[] args){
		try{
			Socket s = new Socket("127.0.0.1", 1004);
			
			//从本客户端输入流中读取到数据放入str中
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			//写入服务器端
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			//从服务器端读入
			BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			while(! str.equals("bye")){
				pw.println(str);
				pw.flush();
				System.out.println("Client: " + str);
				System.out.println("Server: " + br2.readLine());
				str = br.readLine();
			}
			br.close();
			pw.close();
			br2.close();
			s.close();
			
		}catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
		
	}
}
