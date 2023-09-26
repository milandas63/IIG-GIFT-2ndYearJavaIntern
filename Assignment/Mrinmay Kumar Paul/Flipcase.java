public class Flipcase {

	public static void main(String[] args) {
		String str = "Quick Brown Fox Jump Over A Lazy Dog";
		StringBuffer buf = new StringBuffer();
		char c;

		for(int i=0; i<str.length(); i++){
			c = str.charAt(i);
			if(c>=65 && c<=90){
				c=(char)(c+32);
			}else if(c>=97 && c<=122){
				c=(char)(c-32);
			}
				buf.append(c);
		}
			System.out.println(buf.toString());
	}

}

