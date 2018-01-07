package ch6;

import java.io.File;

public class FileList {
	public static void main(String[] args){
		File f = new File("F:/a");
		System.out.println(f.getName());
		tree(f,1);
	}
	
	private static void tree(File f, int level){
		String kong = "";
		
		for(int i=0;i<level;i++){
			kong += "   ";
		}
		
		File[] files = f.listFiles();
		for(int i=0;i<files.length;i++){
			System.out.println(kong + files[i].getName());
			if(files[i].isDirectory()){
				tree(files[i],level + 1);
			}
		}
	}
}
