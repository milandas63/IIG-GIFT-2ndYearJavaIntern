public class Series1 {
	public static void main(String[] args) {
		int seed = 1;
		for(int count=1; count<=10; count++) {
			if(count%2==0) {
				seed = seed*2+1;
			} else {
				seed = seed*2-1;
			}
			System.out.print(seed+"  ");
		}
	}
}
