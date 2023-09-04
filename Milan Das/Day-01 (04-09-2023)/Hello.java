// First Introductory Program
// WAP to print a pyramid of astericks
/*
                    *
                   ***
                  *****
                 *******
                *********
               ***********
              *************
             ***************
            *****************
*/

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World!");

		int spaces = 30;
		int stars = 1;

		for(int lines=0; lines<10; lines++) {
			for(int i=0; i<spaces; i++) System.out.print(" ");
			for(int i=0; i<stars; i++)  System.out.print("*");
			System.out.println();
			spaces = spaces-1;
			stars = stars+2;
		}

		System.out.println();
		System.out.println();
		System.out.println();
		spaces = 30;
		stars = 1;
		for(int lines=0; lines<19; lines++) {
			for(int i=0; i<spaces; i++) System.out.print(" ");
			for(int i=0; i<stars; i++)  System.out.print("*");
			System.out.println();
			if(lines<9) {
				spaces = spaces-1;
				stars = stars+2;
			} else {
				spaces = spaces+1;
				stars = stars-2;
			}
		}

		System.out.println();
		System.out.println();
		System.out.println();
		spaces = 30;
		for(int lines=1; lines<=9; lines++) {
			for(int i=0; i<spaces; i++) System.out.print(" ");
			for(int i=1; i<=lines; i++) System.out.print(i);
			for(int i=lines-1; i>=1; i--) System.out.print(i);
			System.out.println();
			spaces = spaces-1;
			stars = stars+2;
		}

	}
}
