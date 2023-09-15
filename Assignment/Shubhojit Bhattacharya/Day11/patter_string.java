package Day11;

import java.util.Scanner;

public class patter_string {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String s=sc.nextLine();
        int count=0;
        String[] Word=s.split(" ");
        for(int i=0;i<Word.length;i++){
            if(count<Word[i].length()){
                count=Word[i].length();
            }
        }
        for(int i=0;i<=Word.length+1;i++){
            if(i==0||i==Word.length+1){
                for(int j=0;j<count+4;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
            else{
                System.out.println("* " + Word[i-1] + getSpaces(count - Word[i-1].length()) + " *");
            }
        }

        sc.close();
    }

    public static String getSpaces(int count) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < count; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
}
