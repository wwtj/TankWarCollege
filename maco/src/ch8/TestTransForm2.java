package ch8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTransForm2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String s = null;
			while((s = br.readLine()) != null){
				if(s.equalsIgnoreCase("exit")){
					System.exit(-1);
				}
				System.out.println(s.toUpperCase());
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
