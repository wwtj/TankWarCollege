package ch10;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSever {
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(3333);
		while(true){
			Socket s = ss.accept();//����ʽ�ģ�ɵ����
			System.out.println("A client connect.");
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF());//����ʽ�ģ�ɵ����
			dis.close();
			s.close();
		}
	}
}
