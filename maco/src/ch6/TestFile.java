package ch6;

import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args){
		String separator = File.separator;
		String filename = "myfile.txt";
		String directory = "mydir1" + separator + "mydir2";
		File f = new File(directory,filename);//���ļ�ֻ�����ڴ��е�һ�����󣬲�û��������������
		if(f.exists()){
			System.out.println("�ļ�����" + f.getAbsolutePath());
			System.out.println("�ļ���С��" + f.length());
		}else{
			f.getParentFile().mkdirs();
			try{
				f.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}