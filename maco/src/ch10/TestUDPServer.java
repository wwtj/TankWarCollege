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
			//��һ���ֽ������������������ֱ�ӽ�8���ֽ�ֱ��ת��һ��long���͵���
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
			//����ֱ�ӽ�8���ֽ�ֱ��ת��һ��long���͵���
			DataInputStream dis = new DataInputStream(bais);
			System.out.println(dis.readLong());
		}
		
	}
}
