package ch10;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestUDPServer {
	public static void main(String[] args) throws Exception{
		byte[] b = new byte[1024];
		DatagramPacket dp = new DatagramPacket(b, b.length);
		DatagramSocket ds = new DatagramSocket(1000);
		while(true){
			ds.receive(dp);
			//从一个字节数组读东西，但不能直接将8个字节直接转成一个long类型的数
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
			//可以直接将8个字节直接转成一个long类型的数
			DataInputStream dis = new DataInputStream(bais);
			System.out.println(dis.readLong());
		}
		
	}
}
