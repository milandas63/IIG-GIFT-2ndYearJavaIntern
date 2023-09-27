public class assignment2 {
	public static void main(String[] args) {
		int start = 2;
		int end = 25;

		for(int h=start; h<=end; h+=6) {
			for(int i=1; i<=10; i++) {
				for(int j=h; j<=(h+5); j++) {
					System.out.print(padL(j,2) + " x " + padL(i,2) + " = " + padL((i*j),3) + "  ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static String padL(int n, int l) {
		String buf = ""+n;
		for(int i=buf.length(); i<l; i++) {
			buf = " "+buf;
		}
		return buf;
	}
}