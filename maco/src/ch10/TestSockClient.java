package ch10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSockClient {
	public static void main(String[] args){
		InputStream is = null;
		OutputStream os = null;
		try{
			Socket s = new Socket("127.0.0.1", 9111);
			is = s.getInputStream();
			os = s.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("hi2");
			String str = null;
			if((str = dis.readUTF()) != null){
				System.out.println(str);
			}
			dos.flush();
			dos.close();
			dis.close();
			s.close();
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e2){
			e2.printStackTrace();
		}
	}
}
