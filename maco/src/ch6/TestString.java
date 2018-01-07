package ch6;

public class TestString {
	public static void main(String[] args){
		String s = "AaaaaABBBBcc$^%adfsfdCCOOkk99876 _haHA";
		
		//方法1
		int lCount = 0, uCount = 0, oCount = 0;
		for(int i =0;i<s.length();i++){
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
				lCount ++;
			}else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
				uCount ++;
			}else{
				oCount ++;
			}
		}
		System.out.println(lCount + " " + uCount + " " + oCount);
		
		//方法2
		int lCount2 = 0, uCount2 = 0, oCount2 = 0;
		String s1 = "abcdefghijklmnopqrstuvwxyz";
		String s2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i =0;i<s.length();i++){
			char c = s.charAt(i);
			if(s1.indexOf(c) != -1){
				lCount2 ++;
			}else if(s2.indexOf(c) != -1){
				uCount2 ++;
			}else{
				oCount2 ++;
			}
		}
		System.out.println(lCount2 + " " + uCount2 + " " + oCount2);
		
		//方法3
		int lCount3 = 0, uCount3 = 0, oCount3 = 0;
		for(int i =0;i<s.length();i++){
			char c = s.charAt(i);
			if(Character.isLowerCase(c)){
				lCount3 ++;
			}else if(Character.isUpperCase(c)){
				uCount3 ++;
			}else{
				oCount3 ++;
			}
		}
		System.out.println(lCount3 + " " + uCount3 + " " + oCount3);
		
		
		String s3 = "sunjavahpjavaokjavajjavahajavahajavajavagoodjava";
		String s4 = "java";
		int jCount = 0;
		while(s3.indexOf(s4) != -1){
			jCount ++;
			s3 = s3.substring(s3.indexOf(s4)+s4.length());
		}
		System.out.println(jCount);
	}

}
