import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class assignment5 {

	public static void main(String[] args) throws ClassNotFoundException {
		String className = "java.lang.String";
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
