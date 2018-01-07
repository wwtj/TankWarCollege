package ch5;
//数3退1
public class Count3Quit {
	public static void main(String[] args){
		
		boolean[] array = new boolean[500];
		for(int i=0;i<array.length;i++){
			array[i] = true;//true表示在圈中
		}
		
		int count = 0;
		int index = 0;
		int leftNum = array.length;
		
		while(leftNum>1){
			if(array[index] == true){
				count++;
				if(count==3){
					count = 0;
					array[index] = false;
					leftNum--;
				}
			}
			
			index++;
			
			if(index == array.length){
				index = 0;
			}
		}
		
		for(int i=0;i<array.length;i++){
			if(array[i] == true){
				System.out.print(i);
			}
		}
	}

}
