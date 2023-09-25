package com.day3;

import java.util.Date;
import java.util.StringTokenizer;

import com.day02.MTables;

public class PredefinedClasses {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		System.out.println(d.getHours());
		System.out.println(d.getYear());
		
		MTables m1 = new MTables();
		System.out.println("MTables: "+m1);
		
		String x = new String(new byte[] {65,66,67,68,69,70,97,98,99,100,101,102});
		System.out.println(x);
		String y = new String("GIFT University");
		System.out.println(y);
		System.out.println(y.toLowerCase());
		System.out.println(y.toUpperCase());
		
		char c;
		for(int i=0; i<y.length(); i++) {
			c = y.charAt(i);
			if(c>=65 && c<=90) {
				c = (char) (c+32);
			}
			System.out.print(c);
		}
		System.out.println();
		
		y = new String("Hello World");
		System.out.println(y);
		
		
		StringBuffer buf = new StringBuffer(y);
		buf.insert(0, "Dear ");
		System.out.println(buf);
		buf.delete(5, 10);
		System.out.println(buf);
		buf.append(" Hello");
		System.out.println(buf);
		
		
		StringTokenizer allToken = new StringTokenizer("Quick,Brown,Fox,Jumps,Over,The,Lazy,Dog",",");
		System.out.println(allToken.countTokens());
		while(allToken.hasMoreTokens()) {
			System.out.println(allToken.nextToken());
		}
		
	}

}
