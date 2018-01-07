package ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {
	public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(1004);
			Socket s = ss.accept();
			
			//从客户端读进来并打印
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println("Client: " + br.readLine());
			//从本服务器写到客户端
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			//从本服务器输入流获取输入放入str中
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			String str = br2.readLine();
			
			while(! str.equals("bye")){
				pw.println(str);
				pw.flush();
				System.out.println("Server: " + str);
				System.out.println("Client: " + br.readLine());
				str = br2.readLine();
			}
			
			br.close();
			pw.close();
			br2.close();
			s.close();
			ss.close();
			
		}catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
