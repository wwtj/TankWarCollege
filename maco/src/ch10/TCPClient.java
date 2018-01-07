package ch10;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("127.0.0.1", 3333);//127.0.0.1表示本机地址
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("hello,server.");
		dos.flush();
		dos.close();
		s.close();
	}
}
