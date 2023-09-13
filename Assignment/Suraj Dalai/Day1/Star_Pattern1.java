/*
    Write a program to print a pyramid in the following manner>?

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
 */
package Day1;

public class Star_Pattern1 {
    public static void main(String[] args) {
        int numRows = 10; // Number of rows for the pyramid
        
        printHollowPyramid(numRows);
    }

    public static void printHollowPyramid(int numRows) {
        for (int i = 1; i <= numRows; i++) {
            // Print spaces
            for (int j = 1; j <= numRows - i; j++) {
                System.out.print(" ");
            }

            // Print stars or spaces for the pyramid
            for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 1 || k == 2 * i - 1 || i == numRows) {
                    // Print stars at the edges or at the bottom row
                    System.out.print("*");
                } else {
                    // Print spaces for the hollow part
                    System.out.print(" ");
                }
            }

            // Move to the next line after each row
            System.out.println();
        }
    }


}
