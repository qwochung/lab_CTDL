package Task2;

import java.util.Arrays;

public class Task2_Quick_Sort {

	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = subQuickSort(arr, start, end);

			quickSort(arr, start, mid - 1);
			quickSort(arr, mid + 1, end);
		}
	}

	public static int subQuickSort(int[] arr, int start, int end) {

		int pivot = arr[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = temp;

		return i + 1;
	}

	
	
	
	
	
	public static void main(String[] args) {
		int[] arr = {2,45,5,2,3,5,6,7,786,2,2,3,5,6,5,78,67};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
