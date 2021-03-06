package ch5;
//冒泡排序和二分查找
public class BubbleDate {
	public static void main(String[] args){
		Date[] a = new Date[5];
		a[0] = new Date(2006,5,4);
		a[1] = new Date(2006,7,4);
		a[2] = new Date(2008,5,4);
		a[3] = new Date(2004,5,9);
		a[4] = new Date(2004,5,4); 
		
		bubbleDate(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
		System.out.println(binarySearch(a, a[3]));
	}
	
	public static int binarySearch(Date[] a, Date b){
		if(a.length == 0){
			return -1;
		}
		
		int startPos = 0;
		int endPos = a.length-1;
		int m =(startPos + endPos) / 2;
		while(startPos <= endPos){
			if(b.compare(a[m]) == 0){
				return m;
			}
			if(b.compare(a[m]) < 0){
				startPos = m + 1;
			}
			if(b.compare(a[m]) > 0){
				endPos = m - 1;
			}
			m = (startPos + endPos) / 2;
		}
		return -1;
	}
	
	public static Date[] bubbleDate(Date[] a){
		Date temp;
		for(int i=a.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(a[i].compare(a[j])>0){//按时间从晚到早排序
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

}


class Date{
	int x, y, z;
	Date(int x1, int y1, int z1){
		x = x1;
		y = y1;
		z = z1;
	}
    public int compare(Date a){
    	return x >a.x ? 1
    			: x < a.x ? -1
    					:y >a.y ? 1
    							:y<a.y ? -1
    									:z>a.z ? 1
    											:z<a.z ? -1 : 0;
    }
    
    public String toString(){
    	return x+"."+y+"."+z;
    }
}
