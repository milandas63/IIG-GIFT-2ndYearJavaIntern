public class hello{
    public static void main(String[] args){
        System.out.println("Hello World");
        int spaces=30;
        int stars =1;

        for (int lines=0;lines<10;lines++) {
            if(lines<6){
                for (int i=0;i<spaces;i++) {
                    System.out.println("");
                }
                for (int i=0;i<stars;i++) {
                    if (i==0 || i==stars-1) {
                        System.out.println("*");
                    } else {
                        System.out.println();
                    }
                }
            }
            
        }
    }
}
    
