package com.day04;

public class VowelCount {

	public static void main(String[] args) {
		String text = "I am a student of GIFT college";
		char[] vowels = {'A','E','I','O','U','a','e','i','o','u'};
		
		char c;
		int count = 0;
		for(int i=0; i<text.length(); i++) {
			c = text.charAt(i);
			for(int j=0; j<vowels.length; j++) {
				if(c==vowels[j]) {
					count++;
					break;
				}
			}
		}
		System.out.println("Total vowels = "+count);
	}

}
