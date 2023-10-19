
public class Task_1_Basic_Problems {
	
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		int [][] result = new  int [a.length][a.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		
		return result;
	}
	
	
	// add 2 matrices
	public static int[][] subtract(int[][] a, int[][] b) {
		int [][] result = new  int [a.length][a.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = a[i][j] - b[i][j];
			}
		}
		
		return result;
	}

	
	
	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		// check 2 arrays
		if ((a[0].length == b.length) || (b[0].length == a.length) ){
			
			int[][] result = new int [a.length][b[0].length];
			
			for (int i = 0; i < a.length; i++) {
				
				for (int j = 0; j < b[0].length; j++) {
					
					int sum=0;
					for (int k = 0; k < b.length; k++) {
						sum += a[i][k] * b[k][j];
						
					}
					result[i][j] = sum;
					
				}
			
			}
			
			
			return result;
			
		}
		else {
			return null;
		}
		
	}
	
	
	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		int [][]result =  new int[a[0].length][a.length];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				result[j][i] = a[i][j];
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//menthod print 2D arrays
	public static void print2DArrays( int[][]arr) {
		for (int[] is : arr) {
			for (int is2 : is) {
				System.out.print(is2 + " ");
			}
			System.out.println();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int[][] a = {	{7,2},
					 	{5,3}
					};
		
		int[][] b = {	{2,1},
						{3,1}
					};
		int[][] c = {	{2,3,4},
						{1,0,0}

					};
		int[][] d = {	{0 , 1000},
						{1, 100},
						{0, 10 }
					};
		
		int[][] e = {	{1, 2 , 3},
						{4 ,5 , 6},
						{7, 8 , 9}
		};
		int[][] f = {	{1, 2 , 3, 4},
						{4 ,5 , 6, 7},
						{7, 8 , 9, 10}
		};
		
		
		
	
		System.out.println("Test add() :");
		print2DArrays(add(a, b));
		
		System.out.println("Test subtract() :");
		print2DArrays(subtract(a, b));
		
		
		System.out.println("Test multiply() :");
		print2DArrays(multiply(c, d));
		print2DArrays(multiply(f, e));
		
		
		System.out.println("Test transpose() :");
		print2DArrays(transpose(c));
		print2DArrays(transpose(d));
	}
}
