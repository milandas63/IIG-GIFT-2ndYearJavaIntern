package com.Day_o7;

public class Valid_Voter_Id {

	public static void main(String[] args) {
		int ages[] = {24,35,15,54,11,71,88,0,63,19,-33,45,28,91,-31,75};
		for(int i=0;i<ages.length;i++) {
			try {
				checkages(ages[i]);
				System.out.print(ages[i]+"is valid");
			}catch(Too_young_age e) {
				
			}catch(Zeroage_exception e) {
				
			}catch(Negative_Exception e) {
				
			}catch(too_old_age e) {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}		
		
		public static void checkages(int age) throws Too_young_age,Zeroage_exception,too_old_age,Negative_Exception{
			if(age<0) {
				throw new Negative_Exception("age is lessthan zero");
			}
			else if(age>80) {
				throw new too_old_age ("he/she is too old ");
			}
			else if(age<18) {
				throw new Too_young_age("you not valid");
			}
			else if(age==0) {
				throw new Zeroage_exception("you not yet burn");
			}
		}

	}


