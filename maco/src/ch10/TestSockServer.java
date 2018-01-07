package ch10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSockServer {
	public static void main(String[] args){
		InputStream is = null;
		OutputStream os = null;
		try{
			ServerSocket ss = new ServerSocket(9111);
			while(true){
				Socket s = ss.accept();
				is = s.getInputStream();
				os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				DataInputStream dis = new DataInputStream(is);
				
				String str = null;
				if((str = dis.readUTF()) != null){
					System.out.println(str);
					System.out.println("from: " + s.getInetAddress());
					System.out.println("prot: " + s.getPort());
				}
				dos.writeUTF("hi1");
				dos.flush();
				dos.close();
				dis.close();
				s.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
