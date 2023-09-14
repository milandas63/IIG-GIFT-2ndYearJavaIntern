
public class HollowTriangle {

	public static void main(String[] args) {
	
		 int spaces = 20;
		 int stars=1;
		    for(int line=0; line<10; line++){
		        for(int i=0; i<spaces; i++) System.out.print(" ");
		        for(int i=0; i<stars; i++) {
		            if(line < 9){
		            	if(i==0 || i==stars-1){
		            		System.out.print("*");
		            	}else{
		            		System.out.print(" ");
		            	}
		            }else{
		            	System.out.print("*");
		            }
		        }
		        System.out.println();
		        spaces -= 1;
		        stars += 2;
		    }

		    	System.out.println();
System.out.println();
	}
	

}
