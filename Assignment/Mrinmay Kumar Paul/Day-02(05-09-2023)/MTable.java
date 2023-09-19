public class MTable {

	public static void main(String[] args) {
		int start=2;
		int end=25;
		for(int k=start; k<=end; k+=6) {
			for(int i=1; i<=10; i++) {
				for(int j=k; j<=(k+5); j++) {
					System.out.print(padl(j,2) + " x " + padl(i,2) + " = " + padl((i*j),3)+"  ");
				}System.out.println();
			}System.out.println();
		}
	}
	public static String padl(int n, int l) {
		String b=""+n;
		for(int i=b.length(); i<l; i++) {
			b=" "+b;
		}return b;
	}

}
