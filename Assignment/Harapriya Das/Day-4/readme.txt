package com.day4;

public class VowelCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="I am a student of GIFT college";
		char[]vowels= {'A','E','I','O','U','a','e','i','o','u'};
		
		char c;
		int count =0;
		for(int i=0; i<text.length();i++) {
			c=text.charAt(i);
			for(int j=0;j<vowels.length;j++) {
				if(c==vowels[j]) {
					count++;
					break;
				}
			}
		}
		System.out.println("Total vowels = "+count);
		
	}

}
/*OUTPUT:
Total vowels = 10

*/
