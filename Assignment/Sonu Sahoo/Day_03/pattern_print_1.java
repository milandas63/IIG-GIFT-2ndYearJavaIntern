// Question 1.
package com.Day_3
class q1 {
    public static void main(String[] args) {
        int i;
        int space=9;
        for(i=0;i<10;i++)
        {
            for(int l=1;l<=space;l++)
            System.out.print(" ");
            for(int k=1;k<=2*i+1;k++)
            {
                System.out.print(i);
            }
            space--;
            System.out.println();
        }
    }
    
}

// output :-

//          0
//         111
//        22222
//       3333333
//      444444444
//     55555555555
//    6666666666666
//   777777777777777
//  88888888888888888
// 9999999999999999999
