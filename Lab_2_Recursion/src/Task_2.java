import java.util.Arrays;
import java.util.Iterator;

public class Task_2 {
	/**
	 * This method takes as an input one integer value n and then output on console
	 * a pyramid as on figure below for example for n=4: // X // XXX // XXXXX // XXXXXXX
	 */

	public static void drawPyramid(int n) {
		fillX(n, 1);

	}

// Override
	public static void drawPyramid(int n, int len) {
		fillX(n, 1,len);

	}

	
	
	
	public static void pyramidPattern_1(int line ) {
		int[] arr = new int [line*2-1];
		for (int i = 0; i < arr.length; i++) {
			if (i%2 == 0) {
				arr[i] = line;
			}
		}
		
		subForPattern(--line, arr);
		printOnConsole(arr);
	}
	
	
	
	
	
	
	
	
	public static void pyramidPattern_2(int line ) {
		int[] arr = new int [line*2-1];
		int num = 1;
		for (int i = 0; i < arr.length; i++) {
			if (i%2 == 0) {
				arr[i] = num++ ;
			}
		}
		
		subForPattern(--line, arr);
		printOnConsole(arr);
	}
	
	
	
	
	public static void drawChristmasTree(int n) {
		for (int i = 1; i <= n; i++) {
			drawPyramid(i, n);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void subForPattern(int line , int[]arr) {
		int[] subArr = new int[arr.length] ;
		
		
		if (line == 1) {
			subArr[arr.length/2] = line;
			printOnConsole(subArr);
			return;
		}
		
		
		
		for (int i = 0; i < subArr.length; i++) {
			if ((arr[i]!=0 )   ) {
				int count =0;
				for (int j = ++i; j < subArr.length; j+= 2) {
					if (count == line) {
						break;
					}
					subArr[j]= line;
					count++;
				}
				break;
			}
		}
		subForPattern(--line, subArr);
		printOnConsole(subArr);
	}
	
	
	
	
	
	// fill x in arr
	public static void fillX(int n, int line) {
		if (line > n) {
			return;
		} else {

			String[] arr = new String[n * 2 - 1];
			int mid = arr.length / 2;
			for (int i = mid - line + 1; i <= mid + line - 1; i++) {
				arr[i] = "X";
			}
			printOnConsole(arr);
			fillX(n, ++line);
		}
	}
	
	//  Override fill x in arr
	public static void fillX(int n, int line, int len) {
		if (line > n) {
			return;
		} else {

			String[] arr = new String[len * 2 - 1];
			int mid = arr.length / 2;
			for (int i = mid - line + 1; i <= mid + line - 1; i++) {
				arr[i] = "X";
			}
			printOnConsole(arr);
			fillX(n, ++line, len);
		}
	}
	
	
	
	// print arr type 1
	public static void printOnConsole(String[]arr) {
		for (String string : arr) {
			if (string == null) {
				System.out.print(" ");
			}
			else {
				System.out.print(string);
			}
		}
		
		System.out.println();
		
	}
	
//	override printOnConsole
	public static void printOnConsole(int[]arr) {
		for (int num : arr) {
			if (num == 0) {
				System.out.print(" ");
			}
			else {
				System.out.print(num);
			}
		}
		
		System.out.println();
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		drawPyramid(4);
		pyramidPattern_1(9);
		drawChristmasTree(4);
		
		
	
	
	
	}

}
