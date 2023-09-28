
public class Task1_1_Basic_Problems {

	
	// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
	public static int getSn1(int n) {
		int result = 0;
		return subSn1 (result,n);
		}
	
	public static int subSn1(int result, int n ){// menthod support Sn1 
		
		if (n==0) {
			return result;
		}
		
		if (n%2 == 0) {
			result += -1 * n;
			return subSn1(result,--n);
			}
			
		if (n%2 != 0) {	
			result +=  n;
			return subSn1( result,--n);
			}
		
		
		return result;
	}
	
	
	
	// S(n)=1+1.2+1.2.3+…+1.2.3…n, n>0
	public static int getSn2(int n) {

		if (n == 1) {
			return 1;
		}
		
		
		return factorial(n) + getSn2(--n) ;
	}
	
	public static int factorial(int n) { //factorial : giai thừa
		if (n==1) {
			return 1;
		}
//		System.out.println(n);
		return n * factorial(--n) ;
		
		
	}
	
	
	
	// S(n)=1^2+2^2+3^2+....+n^2 , n>0
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		}
	return n*n + getSn3(--n);
	}
	
	
	// S(n)=1+1/2+1/(2.4)+1/(2.4.6)+…+1/(2.4.6.2n), n>=0
	public static double getSn4(int n) {
			if (n == 0) {
				return 1;
			}
			
			return (1.0/denominator(n)) + getSn4(--n) ;
//			
	}
	
	
	public static int denominator(int n) { //denominator : mẫu số
	
		if (n ==1 ) {
			return 2;
		}
		return n*2*denominator(--n);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// test Sn1
		System.out.println(getSn1(4));
		
		System.out.println(getSn2(4));
		
		System.out.println(getSn3(3)); 
		
		
		System.out.println(getSn4(3));
		
		
	}
	
	
	
	
	
}

