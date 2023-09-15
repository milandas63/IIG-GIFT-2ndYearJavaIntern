package Day11;

import java.util.Scanner;

public class Count_Char {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String :");
        String s=sc.nextLine().toUpperCase();
        char[] wordlist={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int arr[]=new int[26]; 
        for(int i=0;i<s.length();i++){
            for(int j=0;j<26;j++){
                if(s.charAt(i)==wordlist[j]){
                    arr[j]+=1;
                }
            }
        }
        for(int i=0;i<26;i++){
            if (arr[i]>0) {
                System.out.println(wordlist[i]+"-"+arr[i]);
            }
        }
        sc.close();
    }
}
