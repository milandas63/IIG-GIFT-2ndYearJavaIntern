package com.day5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {

	public static void main(String[] args) throws ClassNotFoundException {
		String className = "java.lang.String";
		//String className = "com.day04.VowelCount";
		Class obj = Class.forName(className);
		Field f[] = obj.getDeclaredFields();
		Constructor c[] = obj.getDeclaredConstructors();
		Method m[] = obj.getDeclaredMethods();
		
		System.out.println(className);
		for(int i=0; i<className.length(); i++) System.out.print("-");
		System.out.println();
		
		if(f.length>0) {
			System.out.println("FIELDS:");
			for(int i=0; i<f.length; i++) {
				System.out.println((i+1)+": "+removePackage(f[i].toString()));
			}
		}

		if(c.length>0) {
			System.out.println("CONSTRUCTORS:");
			for(int i=0; i<c.length; i++) {
				System.out.println((i+1)+": "+removePackage(c[i].toString()));
			}
		}
		
		if(m.length>0) {
			System.out.println("METHODS:");
			for(int i=0; i<m.length; i++) {
				System.out.println((i+1)+": "+removePackage(m[i].toString()));
			}
		}
		
	}

	public static String removePackage(String text) {
		StringBuffer buf = new StringBuffer();
		
		char c;
		boolean yesNo = true;
		for(int i=text.length()-1; i>=0; i--) {
			c = text.charAt(i);
			switch(c) {
			case '.': yesNo = false; break; 
			case ' ': yesNo = true; break; 
			case ',': yesNo = true; break; 
			case '(': yesNo = true; break; 
			case ')': yesNo = true; break; 
			case '[': yesNo = true; break; 
			case ']': yesNo = true; break;
			}
			
			if(yesNo) {
				buf.insert(0, c);
			}
		}
		
		return buf.toString();
	}
}
OUTPUT:
java.lang.String
----------------
FIELDS:
1: private final char[] value
2: private int hash
3: private static final long serialVersionUID
4: private static final ObjectStreamField[] serialPersistentFields
5: public static final Comparator CASE_INSENSITIVE_ORDER
CONSTRUCTORS:
1: public String(byte[],int,int)
2: public String(byte[],Charset)
3: public String(byte[],String) throws UnsupportedEncodingException
4: public String(byte[],int,int,Charset)
5: public String(byte[],int,int,String) throws UnsupportedEncodingException
6: String(char[],boolean)
7: public String(StringBuilder)
8: public String(StringBuffer)
9: public String(byte[])
10: public String(int[],int,int)
11: public String()
12: public String(char[])
13: public String(String)
14: public String(char[],int,int)
15: public String(byte[],int)
16: public String(byte[],int,int,int)
METHODS:
1: public boolean equals(Object)
2: public String toString()
3: public int hashCode()
4: public int compareTo(String)
5: public int compareTo(Object)
6: public int indexOf(String,int)
7: public int indexOf(String)
8: public int indexOf(int,int)
9: public int indexOf(int)
10: static int indexOf(char[],int,int,char[],int,int,int)
11: static int indexOf(char[],int,int,String,int)
12: public static String valueOf(int)
13: public static String valueOf(long)
14: public static String valueOf(float)
15: public static String valueOf(boolean)
16: public static String valueOf(char[])
17: public static String valueOf(char[],int,int)
18: public static String valueOf(Object)
19: public static String valueOf(char)
20: public static String valueOf(double)
21: public char charAt(int)
22: private static void checkBounds(byte[],int,int)
23: public int codePointAt(int)
24: public int codePointBefore(int)
25: public int codePointCount(int,int)
26: public int compareToIgnoreCase(String)
27: public String concat(String)
28: public boolean contains(CharSequence)
29: public boolean contentEquals(CharSequence)
30: public boolean contentEquals(StringBuffer)
31: public static String copyValueOf(char[])
32: public static String copyValueOf(char[],int,int)
33: public boolean endsWith(String)
34: public boolean equalsIgnoreCase(String)
35: public static String format(Locale,String,Object[])
36: public static String format(String,Object[])
37: public void getBytes(int,int,byte[],int)
38: public byte[] getBytes(Charset)
39: public byte[] getBytes(String) throws UnsupportedEncodingException
40: public byte[] getBytes()
41: public void getChars(int,int,char[],int)
42: void getChars(char[],int)
43: private int indexOfSupplementary(int,int)
44: public native String intern()
45: public boolean isEmpty()
46: public static String join(CharSequence,CharSequence[])
47: public static String join(CharSequence,Iterable)
48: public int lastIndexOf(int)
49: public int lastIndexOf(String)
50: static int lastIndexOf(char[],int,int,String,int)
51: public int lastIndexOf(String,int)
52: public int lastIndexOf(int,int)
53: static int lastIndexOf(char[],int,int,char[],int,int,int)
54: private int lastIndexOfSupplementary(int,int)
55: public int length()
56: public boolean matches(String)
57: private boolean nonSyncContentEquals(AbstractStringBuilder)
58: public int offsetByCodePoints(int,int)
59: public boolean regionMatches(int,String,int,int)
60: public boolean regionMatches(boolean,int,String,int,int)
61: public String replace(char,char)
62: public String replace(CharSequence,CharSequence)
63: public String replaceAll(String,String)
64: public String replaceFirst(String,String)
65: public String[] split(String)
66: public String[] split(String,int)
67: public boolean startsWith(String,int)
68: public boolean startsWith(String)
69: public CharSequence subSequence(int,int)
70: public String substring(int)
71: public String substring(int,int)
72: public char[] toCharArray()
73: public String toLowerCase(Locale)
74: public String toLowerCase()
75: public String toUpperCase()
76: public String toUpperCase(Locale)
77: public String trim()
