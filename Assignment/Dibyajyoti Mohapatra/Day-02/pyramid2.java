package iiginternship;

public class pyramid2 {
	    public static void main(String[] args) {
	        int n = 10; 

	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n - i; j++) {
	                System.out.print(" ");
	            }
	            for (int k = 1; k <= i; k++) {
	                if (k == 1 || k == i || i == n) {
	                    System.out.print("*");
	                } else {
	                    System.out.print(" ");
	                }
	            }
	            for (int l = i - 1; l >= 1; l--) {
	                if (l == 1 || l == i || i == n) {
	                    System.out.print("*");
	                } else {
	                    System.out.print(" ");
	                }
	            }
	            System.out.println();
	        }
	    }
	}