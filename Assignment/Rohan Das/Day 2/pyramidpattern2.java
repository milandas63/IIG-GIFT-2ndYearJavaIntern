
  public class pyramidpattern2
  {

    public static void main(String[] args) {
        int i;
        int space = 1;
        for (int l = 1; l <= 9; l++)
            System.out.print(l);
        for (int l = 8; l >= 1; l--)
            System.out.print(l);
        System.out.println();
        for (i = 8; i >= 1; i--) {
            for (int l = 1; l <= i; l++)
                System.out.print(l);
            for (int l = 1; l <= space; l++)
                System.out.print(" ");
            for (int l = i; l >= 1; l--)
                System.out.print(l);
            space = space + 2;
            System.out.println();
        }

    }

}