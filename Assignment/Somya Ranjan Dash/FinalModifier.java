package com.day04;

public class FinalModifier {
	public final double PI;
	
	public FinalModifier() {
		PI = 3.141;
		//Parent p = new Parent();
		Parent.print();
	}

	public static void main(String[] args) {
		new FinalModifier();
	}



}

final class Parent {
	public static void print() {
		System.out.println("I am a GIFT student");
	}
}
