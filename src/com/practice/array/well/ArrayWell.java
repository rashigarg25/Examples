package com.practice.array.well;

public class ArrayWell {

	public static void main(String[] args) {

		int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 0, 3, 4 };

		int i = 0;

		while (arr[i] <= 0) {
			i++;
		}

		boolean inc = false;
		boolean dec = true;
		int end = i, start = i;
		int totalWater = 0;
		for (int j = i; j < arr.length - 1; j++) {

			if (dec && arr[j] > arr[j + 1]) {
				end = j + 1;
			} else if (dec && arr[j] < arr[j + 1]) {
				dec = false;
				inc = true;
				continue;
			}

			if (inc && arr[j] < arr[j + 1]) {
				end = j + 1;
				if (j + 1 == arr.length - 1) {
					end = j + 1;
					totalWater += calculateWater(arr, start, end);
				}
			} else if (inc && arr[j] > arr[j + 1]) {
				end = j;
				totalWater += calculateWater(arr, start, end);
				start = j;
				dec = true;
				inc = false;
			}

		}
		System.out.println("Max water = " + totalWater);
	}

	private static int calculateWater(int[] arr, int start, int end) {

		int minVal;
		if (arr[end] - arr[start] > 0) {
			minVal = arr[start];
		} else {
			minVal = arr[end];
		}

		int maxWater = minVal * (end - start - 1);
		int sum = 0;
		for (int i = start + 1; i < end; i++) {
			sum += arr[i];
		}

		System.out.println("start = " + start + ", end = " + end);

		return (maxWater - sum);

	}

}
