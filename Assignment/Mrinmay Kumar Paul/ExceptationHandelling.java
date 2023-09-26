public class ExceptationHandelling {

	public static void main(String[] args) {
		int n = 125;
		int d = 0;
		int arr[]={1,2};
		try {
			double r = n/d;
            System.out.println(arr[2]);
			System.out.println("There is no exception");
			System.out.println("Other lines");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException");
        }catch(ClassCastException e) {
			System.out.println("ClassCastException");
		} catch(ArithmeticException e) {
			System.out.println("ArithmeticException");
		} catch(IllegalArgumentException e) {
			System.out.println("IllegalArgumentException");
		}

	}

}


	


