package ch5;
//选择排序
public class SelectDate1 {
	public static void main(String[] args){
		Date1[] a = new Date1[5];
		a[0] = new Date1(2006,5,4);
		a[1] = new Date1(2006,7,4);
		a[2] = new Date1(2008,5,4);
		a[3] = new Date1(2004,5,9);
		a[4] = new Date1(2004,5,4);
		
		selectDate1(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
	
	public static Date1[] selectDate1(Date1[] a){
		int t;//用t代表数组中数字最大（年份最小）的一个元素的下标
		Date1 temp;
		for(int i=0;i<a.length;i++){
			t = i;
			for(int j=t+1;j<a.length;j++){
				if(a[j].compare(a[t])>0){
					t = j;
				}
			}
			if(t!=i){
				temp = a[i];
				a[i] = a[t];
				a[t] = temp;
			}
		}
		return a;
	}

}


class Date1{
	int y, m, d;
	Date1(int y1, int m1, int d1){
		y = y1;
		m = m1;
		d = d1;
	}
	public int compare(Date1 a){
		return y>a.y ? 1
    			: y<a.y ? -1
    					:m>a.m ? 1
    							:m<a.m ? -1
    									:d>a.d ? 1
    											:d<a.d ? -1 : 0;
	}
	public String toString (){
		return y+"."+m+"."+d;
	}
}