package iiginternship;

public class ExceptionHandling {
public static void main(String[] args) {
			int n = 125;
			int d = 0;
			String gods[] = {"Ganesh","Saraswati","Viswakarma"};
			int j = 3;
			String college = "GIFT University";
			int pos = 30;
			String no = "30O";
			
			for(int k=1; k<5; k++) {
				try {
					double r = n/d;
					System.out.println(gods[j]);
					System.out.println(college.charAt(pos));
					System.out.println(Integer.parseInt(no));
					System.out.println("There is no exception");
					System.out.println("Other lines");
				} catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("ArrayIndexOutOfBoundsException");
					j = 1;
					k--;
				} catch(NumberFormatException e) {
					System.out.println("NumberFormatException");
					no = "300";
					k--;
				} catch(ClassCastException e) {
					System.out.println("ClassCastException");
				} catch(ArithmeticException e) {
					System.out.println("ArithmeticException");
					d = 5;
					k--;
				} catch(IllegalArgumentException e) {
					System.out.println("IllegalArgumentException");
				} catch(StringIndexOutOfBoundsException e) {
					System.out.println("StringIndexOutOfBoundsException e");
					pos = 10;
					k--;
				}
			}
		}

}
