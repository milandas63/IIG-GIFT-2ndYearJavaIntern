public class assignment4 {

	public static void main(String[] args) {
		String text ="Java is an Object Oriented Programming Language";
		char[] vowels = {'A','E','I','O','U','a','e','i','o','u'};
		char c;
		int count=0;
		for(int i=0;i<text.length();i++)
		{
			c=text.charAt(i);
			for(int j=0;j<vowels.length;j++) {
				if(c==vowels[j])
				{
					count++;
					break;
				}
				
			}
			
		}
		System.out.println("Total vowels="+count);

	}

}
