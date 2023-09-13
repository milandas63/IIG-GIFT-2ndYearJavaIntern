package com.day08;

public class VoterId {
	public static void main(String[] args) {
		int ages[] = {24,35,15,54,11,71,88,0,63,19,-33,45,28,91,-31,75};
		for(int i=0; i<ages.length; i++) {
			try {
				checkAge(ages[i]);
				System.out.println(ages[i]+" is a valid age");
			} catch(NegativeAgeException e) {
				System.out.println(ages[i]+" is a Negative age "+e.getMessage());
			} catch(ZeroAgeException e) {
				System.out.println(ages[i]+" is a Zero age "+e.getMessage());
			} catch(TooYoungAgeException e) {
				System.out.println(ages[i]+" is too young age "+e.getMessage());
			} catch(TooOldAgeException e) {
				System.out.println(ages[i]+" is too old age "+e.getMessage());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void checkAge(int age) throws NegativeAgeException,
												ZeroAgeException,
												TooYoungAgeException,
												TooOldAgeException {
		if(age<0) throw new NegativeAgeException("age < 0");
		else if(age==0) throw new ZeroAgeException("age = 0");
		else if(age<18) throw new TooYoungAgeException("age < 18");
		else if(age>80) throw new TooOldAgeException("age > 80");
	}
}

/*
OUTPUT:
24 is a valid age
35 is a valid age
15 is too young age age < 18
54 is a valid age
11 is too young age age < 18
71 is a valid age
88 is too old age age > 80
0 is a Zero age age = 0
63 is a valid age
19 is a valid age
-33 is a Negative age age < 0
45 is a valid age
28 is a valid age
91 is too old age age > 80
-31 is a Negative age age < 0
75 is a valid age


*/
