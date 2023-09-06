package com.day3;


/*
			         a         
			        aba        
			       abcba       
			      abcdcba      
			     abcdedcba     
			    abcdefedcba    
			   abcdefgfedcba   
			  abcdefghgfedcba  
			 abcdefghihgfedcba 
			abcdefghijihgfedcba
 */
public class AlphaPyramid {

	public static void main(String[] args) {
		int s = 35;
		for(int i=97; i<=107; i++) {
			for(int j=0; j<s; j++) System.out.print(" ");
			for(int j=97; j<i; j++) System.out.print((char)j);
			for(int j=i-2; j>=97; j--) System.out.print((char)j);
			System.out.println();
			s--;
		}
	}

}
