package com.day04;

public class StaticModifier {
	public String father;
	public static String child;
	
	public StaticModifier() {
		father = "Biju Patnaik";
		child = "Naveen Patnaik";
	}

	public static void main(String[] args) {
		StaticModifier s1 = new StaticModifier();
		StaticModifier s2 = new StaticModifier();
		StaticModifier s3 = new StaticModifier();
		
		System.out.println("s1: father="+s1.father+" child="+s1.child);
		System.out.println("s2: father="+s2.father+" child="+s2.child);
		System.out.println("s3: father="+s3.father+" child="+s3.child);
		
		System.out.println();
		s2.father = "Rajeev Gandhi";
		s2.child = "Rahul Gandhi";

		System.out.println("s1: father="+s1.father+" child="+s1.child);
		System.out.println("s2: father="+s2.father+" child="+s2.child);
		System.out.println("s3: father="+s3.father+" child="+s3.child);
	}

}
