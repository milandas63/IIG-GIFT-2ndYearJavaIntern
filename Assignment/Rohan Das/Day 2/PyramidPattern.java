package iiginternship;
public class PyramidPattern {
    public static void main(String[] args) {
        int height = 9; 
        
       
        for (int i = 0; i < height; i++) {
            
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");
            }
            
            
            for (int j = 0; j < 2 * i + 1; j++) {
                if (j == 0 || j == 2 * i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
           
            System.out.println();
        }
        
       
        for (int i = 0; i < 2 * height + 1; i++) {
            System.out.print("*");
        }
    }
}