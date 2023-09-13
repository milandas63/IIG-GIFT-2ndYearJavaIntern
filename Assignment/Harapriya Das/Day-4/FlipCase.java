package com.day4;

public class flipcase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text = "Quick Brown Fox Jumps Over The Lazy Dog";
		StringBuffer buf = new StringBuffer();
		char c;
		for(int i=0;i<text.length();i++) {
			c=text.charAt(i);
			if(c>=65 && c<=90) {
				c=(char)(c+32);
			}
			else if (c>=97 && c<=122) {
				c=(char)(c-32);
			}
			buf.append(c);
		}
		System.out.println(buf.toString());
	}

}
/*OUTPUT:
Total vowels = 10

*/
