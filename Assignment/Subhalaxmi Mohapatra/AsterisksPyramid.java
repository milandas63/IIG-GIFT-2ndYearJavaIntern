package com.day1;
public class asteriskspyramid {
 public static void main(String[] args) {
        int sizeOfPyramid = 8;
        for(int i=1;i<=sizeOfPyramid;i++) {
        for(int j=i;j<=sizeOfPyramid-1;j++) {
                System.out.print(" ");
            }
        for(int k=1;k<=2*i-1;k++){
                System.out.print("*");
            }
            System.out.println("");
 }
  }
}
/*OUTPUT:
       *
      ***
     *****
    *******
   *********
  ***********
 *************
***************
