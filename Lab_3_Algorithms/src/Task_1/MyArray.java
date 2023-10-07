package Task_1;


public class MyArray {
	private int[] array;
	
	
	public MyArray(int[] array) {
	this.array = array;

	}
	
	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	
	
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		
		
		return -1;
		}
	
	
	
	
	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public int recursiveLinearSearch(int target) {
		
		return subRecursion(target, 0);
	}

	
	
	
	
	// To find the index of the target in the sorted array. If the
//	target is not found in the array, then the method returns -1.
	
	public int iterativeBinarySearch(int target) {
		int start = 0;
		int end = array.length-1;
		
		while (start <= end) {
			int mid =start + (end - start)/2 ;
			
			if (array[mid] == target) {
				return mid;
			}
			
			if (array[mid] < target) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
			
		}
		return -1;
		
	}

	
	
	
	
	// To find the index of the target in the sorted array. 
	//If the target is not found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target) {
//		target = Arrays.sort(array);
		return subRecursion(target, 0, array.length-1);
		
	}

	
	
	
	
	
	
	
	public int  subRecursion( int target, int index) {
		if (index > array.length-1) {
			return -1;
		}
		
		if (array[index] == target) {
			return index;
		}
		else {
			return subRecursion(target, ++index);
		}
		
		
		
	}
	
	
	public int  subRecursion(int target, int start, int end) {
		int mid = start + (end - start) /2;
		
		if (start > end) {
			return -1;
		}
		
		if (array[mid] == target) {
			return mid;
		}
		if (array[mid] < target) {
			return subRecursion(target, ++mid, end);
		}
		
		else {
			return subRecursion(target, start, --mid);
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = new int [] {1,2,3,4,5,6,7,8,31,3,5,6,34,2,2,4,65,7,8,41};
		int[] arr2 = new int [] {10,11,12,13,14,15,16,17,18};
		int[] arr3 = new int [] {18,17,16,15,14,13,12,11,10};
		
		MyArray myArray = new MyArray(arr);
		MyArray myArray2 = new MyArray(arr2);
		MyArray myArray3 = new MyArray(arr3);
		
		
		System.out.println(myArray.iterativeLinearSearch(100));
		System.out.println(myArray.recursiveLinearSearch(3));
		
		
		
		System.out.println(myArray2.iterativeBinarySearch(15));
		System.out.println(myArray3.recursiveBinarySearch(15));
		
		
		
	}
	
	
	
}

