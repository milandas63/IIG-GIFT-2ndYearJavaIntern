
public class NumPyramid {

	public static void main(String[] args) {
		int space=20;
		for(int line=-2; line<=9; line++) {
			for(int i=0; i<=space; i++) System.out.print(" ");
			for(int i=0; i<line; i++) {
				System.out.print(line);
				
			}
			for(int i=line-2; i>=-2; i--) {
				System.out.print(line);
				
				
			}space-=1;

			System.out.println();	
		}

	}

}
