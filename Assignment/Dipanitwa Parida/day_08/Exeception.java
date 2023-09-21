package com.day8;
public class ExceptionHandling1 {
public static void main(String[] args) {
		int n = 125;
		int d = 0;
		
		try {
			double r = n/d;
			System.out.println("There is no exception");
			System.out.println("Other lines");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException");
		} catch(ClassCastException e) {
			System.out.println("ClassCastException");
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException");
		} catch(IllegalArgumentException e) {
			System.out.println("IllegalArgumentException");
		}

	}

}

class MyException extends Throwable {
	
}
OUTPUT:
ArithmeticException