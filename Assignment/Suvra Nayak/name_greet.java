	package com.day1;
		import java.util.Scanner;
		public class name_greet {
		    public static void main(String[] args){
		        Scanner sc= new Scanner(System.in);
		        System.out.print("Enter Your Name!: ");
		        String s=sc.next();
		        System.out.println("Good Morning!"+", "+s);
		        sc.close();
		    }
		}
