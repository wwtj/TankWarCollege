package ch10;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TestClient {
	public static void main(String[] args){
		try{
			Socket s = new Socket("127.0.0.1", 1111);
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("程序运行出错");
		}
	}
}
