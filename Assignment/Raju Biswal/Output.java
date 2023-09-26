package com.day09;

import java.util.Scanner;

public class Output {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: ");
		String user = sc.nextLine();
		System.out.println("Hello "+user);
	}
}
