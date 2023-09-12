package com.day1;
public class pyramid {
    public static void main(String[] args) {
        int numRows = 10; 
         printHollowPyramid(numRows);
    }
public static void printHollowPyramid(int numRows) {
        for (int i = 1; i <= numRows; i++) {
        for (int j = 1; j <= numRows - i; j++) {
                System.out.print(" ");
            }
        for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 1 || k == 2 * i - 1 || i == numRows) {
                System.out.print("*");
                } else {
                System.out.print(" ");
                }
            }
                System.out.println();
        }
    }
}
/*OUTPUT:
         *
        * *
       *   *
      *     *
     *       *
    *         *
   *           *
  *             *
 *               *
*******************
