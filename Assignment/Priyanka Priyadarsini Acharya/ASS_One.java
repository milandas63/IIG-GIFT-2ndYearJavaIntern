
//     *          Analyze the row and coloumn
//    *  *
//   *    *
//  *      *
// **********



public class HolloTriangle {
    public static void main(String[] args) {
        int n = 5;
        int is = -1;
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                for (int j = 1; j <=(2*n)-1; j++) {
                    System.out.print("*");
                }
            }
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            System.out.print("* ");

            for (int j = 1; j <= is; j++) {
                System.out.print(" ");
            }
            is+=2;
            if (i > 1 && i < n) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

}
