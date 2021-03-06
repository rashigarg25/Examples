
package com.practice.problems;

import java.util.Arrays;

public class SortArray012 {

	public static void main(String... args) {

		SortArray012 sortArray = new SortArray012();
		int[] arr = new int[] { 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 2 };
		sortArray.sort(arr);
	}

	private void sort(int[] arr) {

		int pivot = 1;
		int i = 0, j = 0;
		int k = arr.length - 1;
		while (j <= k) {
			if (arr[j] < pivot) { // if value is 0
				swap(arr, i, j);
				i++;
				j++;
			} else if (arr[j] > pivot) { // if value is 2
				swap(arr, j, k);
				k--;
			} else { // if value is 1
				j++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int arr[], int index1, int index2) {

		arr[index1] = arr[index1] + arr[index2];
		arr[index2] = arr[index1] - arr[index2];
		arr[index1] = arr[index1] - arr[index2];
	}
}
