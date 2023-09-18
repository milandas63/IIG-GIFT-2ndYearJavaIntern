package D_Functions;

public class Table {
    public static void printTable(int num) {
        for (int i = 1; i <= 10; i++) {
            int n = 1;
            while (n <= num) {
                System.out.print(n + "*"+i+ "="+n*i +"\t");
                n++;
            }
            System.out.println();
            System.out.println();
        }

    }

    public static void main(String[] args) {
       
        printTable(10);

    }

}
