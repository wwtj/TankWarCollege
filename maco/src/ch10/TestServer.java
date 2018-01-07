package ch10;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(1111);
			while(true){				
				Socket s = ss.accept();
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF("hello " + s.getInetAddress() + " port# " +s.getPort() + ", bye-bye");
				dos.flush();
				dos.close();
				s.close();
			}
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("程序运行出错");
		}
	}
}
