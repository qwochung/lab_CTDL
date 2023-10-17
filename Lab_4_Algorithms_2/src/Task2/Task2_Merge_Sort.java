package Task2;

import java.util.Arrays;

public class Task2_Merge_Sort {
	
	
	
	
	// sort by descending order
	public static void mergeSort(int[] array) {

		subMergeSort(array, 0, array.length-1);
	}
	
	
	
	public  static void subMergeSort(int[]arr , int start, int end) {
		
		if(start < end) {
			int  mid =  (end + start)/2;
			subMergeSort(arr, start, mid);
			subMergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);

		}
		
		
		
	}
	
	
	public static void merge(int[]arr, int start, int mid, int end) {
//		kích thước 2 mãng con
		int len1= mid -start +1;
		int len2 = end - mid;
		
//		Tạo mãng tạm
		int[]arr1 = new int[len1];
		int[]arr2 = new int[len2];
		
//		Đưa dữ liệu vào mãng
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr[start+i];
		}

		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = arr[mid+i +1];
		}
		
		int i = 0,j =0;
		int k = start;
		
		while (i < len1  && j < len2) {
			if (arr1[i] <= arr2[j]) {
				arr[k++] = arr1[i++];
			}
			else {
				arr[k++] = arr2[j++];
			}
			
		}
		
		

        // Sao chép các phần tử còn lại của L[] và R[] nếu còn.
        while (i < len1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < len2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
		
		
		
		
		
	}
	
	
	// sort by ascending order
	public static void quickSort (int[] array) {
		
		
		
		return ;
	}
	
	public static void subQickSort(int[]arr, int start, int end, int pivot) {
		if (start<end) {
			
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,4,5,1,53,21};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}
