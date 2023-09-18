public class pyramid3 {
    public static void main(String[] args) {
        int n = 10; 
        int spaces = n - 1;
        int stars = 1;

        for (int i = 1; i <= n; i++) {
        
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

        
            for (int j = 1; j <= stars; j++) {
                if (i == n) {
                    System.out.print("*");
                } else {
                    if (j == 1 || j == stars) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }

        
            System.out.println();
            spaces--;
            stars += 2;
        }
    }
}