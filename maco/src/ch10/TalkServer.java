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
			
			//�ӿͻ��˶���������ӡ
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println("Client: " + br.readLine());
			//�ӱ�������д���ͻ���
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			//�ӱ���������������ȡ�������str��
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
