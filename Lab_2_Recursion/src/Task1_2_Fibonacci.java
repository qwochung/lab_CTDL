
public class Task1_2_Fibonacci {

	// get the nth value of the Fibonacci series
	public static int getFibonacci(int n) {
		if (n <= 1) {
			return 1;
		}
		return getFibonacci(n - 1) + getFibonacci(n - 2);
	}

	// This method is used to display a Fibonaccci series based on
	// the parameter n. Ex. n=10 ==> 0 1 1 2 3 5 8 13 21 34
	public static void printFibonacci(int n) {
		subFi(n-2);

	}
	
	
	public static void subFi(int n) {
		if (n <0) {
			System.out.println(0);
		}
		
		if (n >=0) {
			int result = 0;
			result = getFibonacci(n);
			subFi(--n);
			System.out.println(result);
		}
		
		
	}
	
	
	
	public static int name(int n) { // qui hoạch động
		if (n == 0) {
			return 0;
		}
		if (n ==1 || n==2) {
			return 1;
		}
//		 f1 = f2 = 1
		int pre = 1 , cur = 1;
		for (int i = 3; i <= n; i++) {
			int fi= pre + cur;
			pre = cur;
			cur = fi;
			System.out.println(cur);
		}
		return cur;
		
		
	}
	
	

	public static void main(String[] args) {
		printFibonacci(10);
		
//		System.out.println(name(5));
	}

}
