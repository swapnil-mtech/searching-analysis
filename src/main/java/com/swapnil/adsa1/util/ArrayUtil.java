package com.swapnil.adsa1.util;

import java.util.Random;

/**
 * Created by swapn on 26-09-2015.
 */
public final class ArrayUtil {

	private static Random random = new Random();

	private ArrayUtil() {
	}

	public static int[] createArray(int length) {
		System.out.println("Generating Integer Array of length " + length);
		int[] array = new int[length];
		for (int i = array.length - 1; i > 0; i--) {
			array[i] = random.nextInt(i + 1);
		}
		return array;
	}

	public static void shuffleArray(int[] array) {
		System.out.println("Shuffling Array...");
		for (int i = array.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			swap(i, index, array);
		}
	}

	public static void swap(int i, int j, int[] inputArray) {
		int temp = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
	}

	public static void display(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static int maxValue(int[] array) {
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++)
			if (array[i] > maxValue)
				maxValue = array[i];
		return maxValue;
	}

	public static int minValue(int[] array) {
		int minValue = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++)
			if (array[i] < minValue)
				minValue = array[i];
		return minValue;
	}
	
	public static void quickSort(int[] inputArray, int startIndex, int endIndex) {

        int i = startIndex;
        int j = endIndex;

        int pivotIndex = startIndex + (endIndex - startIndex) / 2;
        int pivot = inputArray[pivotIndex];

        while (i <= j) {
            // left side value from pivot (i.e. for values between startIndex and pivotIndex),
            // is less than pivot value. increment i
            while (inputArray[i] < pivot) {
                i++;
            }
            // right side value from pivot (i.e. for values between pivotIndex and endIndex ),
            // is less than pivot value. decrement i
            while (inputArray[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(i, j, inputArray);
                i++;
                j--;
            }
        }

        if (startIndex < j)
            quickSort(inputArray, startIndex, j);
        if (i < endIndex)
            quickSort(inputArray, i, endIndex);
    }

}