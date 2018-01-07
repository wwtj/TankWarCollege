package ch8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TestDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		
		try{
			dos.writeDouble(Math.random());
			dos.writeBoolean(true);
			
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());//ÊÇbaos²»ÊÇdos
			System.out.println(bais.available());
			
			DataInputStream dis = new DataInputStream(bais);
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			
			dis.close();
			dos.close();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
