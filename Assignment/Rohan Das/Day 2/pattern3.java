package javaprogram;

public class pattern3 {
	 public static void main(String[] args) {
	        int space =15;
	        int limit=1;
	        int line;
	        for( line=1; line <=8;line++){
	            for(int i=1;i<=line;i++){
	                System.out.print(i);
	            }
	            for(int j=1; j<=space;j++){
	                System.out.print(" ");
	            }

	            for(int k=line;k>0;k--){
	                System.out.print(k);
	            }
	            limit=limit+1;
	            space=space-2;  
	            System.out.println();
	        }
	        for(int i=1;i<=9;i++)
	        {
	            System.out.print(i);
	        }
	        for(int i=8;i>=1;i--)
	        {
	            System.out.print(i);
	        }
	    }
}
