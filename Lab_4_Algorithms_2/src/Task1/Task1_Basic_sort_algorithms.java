package Task1;

import java.util.Arrays;

public class Task1_Basic_sort_algorithms {

	// sort by descending order
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			int minIndex = i;
			
			for (int j = i+1; j < array.length ; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			swap(array, i, minIndex);
			
			
			
		}
		return;
	}

	
	
	
	// sort by descending order
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-1; j++) {
				if (array[j] > array[j+1]) {
					swap(array, j, j+1);
				}
			}
		}
		
		return ;
	
	}
	
	
	
	
	// sort by descending order
	public static void insertionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			recursion(array, i, i);
			
		}
	}
	
	
	
	
	
	
	
	
//	menthod swap support for ....
	public static void swap(int[] arr, int i, int j) {
		arr[i] += arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
	}
	
	
//	recursion support for insertionSort 
	public static void recursion( int[]arr, int i, int index) {
		if (index == 0) {
			return;
		}
		if (arr[i] < arr [index]) {
			swap(arr, i, index);
			recursion(arr, index, --index);
		}
		
		recursion(arr, i, --index);
	}
	
	

	public static void main(String[] args) {
		int[] arr = new int[] { 9, 19, 7,1,3,4,6};
//		selectionSort(arr);
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
		
	}
}
