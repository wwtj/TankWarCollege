package ch10;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TestUDPClient {
	public static void main(String[] args) throws Exception{
		//��long���͵���д�뵽�ֽ�������
		long l = 10000L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(l);
		//�õ��Ǹ��ֽ����飬���ֽ�����򵽰�����
		byte[] b = baos.toByteArray();
		DatagramPacket dp = new DatagramPacket(b, b.length, new InetSocketAddress("127.0.0.1", 1000));
		DatagramSocket ds = new DatagramSocket(1001);
		ds.send(dp);
		ds.close();
	}
}
