package SortMethods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/*
 * Name: Haider Khan
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 * Class: CSC 202- Data Structures
 * Purpose: To demonstrate sorting algorithms and methods
 */

public class SortMethods {

	public static void quickSort(int[] array) {
		if (array.length < 2) {
			return;
		}
		quickSortStep(array, 0, array.length - 1);
	}

	private static void quickSortStep(int[] array, int leftBound, int rightBound) {
		if (array == null || array.length == 0)
			return;
		if (leftBound >= rightBound) {
			return; // The indices have crossed
		}

		int pivot = array[randInt(leftBound, rightBound)];

		// Make left < pivot and right > pivot
		int i = leftBound, j = rightBound;
		while (i <= j) {
			while (array[i] < pivot)
				i++;
			while (array[j] > pivot)
				j--;
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		// Recursively sort two sub parts
		if (leftBound < j)
			quickSortStep(array, leftBound, j);
		if (rightBound > i)
			quickSortStep(array, i, rightBound);
	}

	// We use an insertion sort example
	public static void insertionSort(int[] array) {
		// The insertion sort will start from the second element
		for (int i = 1; i < array.length; i++) {
			int numberToInsert = array[i];

			int compareIndex = i;
			while (compareIndex > 0 && array[compareIndex - 1] > numberToInsert) {
				array[compareIndex] = array[compareIndex - 1]; // Shift the
																// elements
				compareIndex--; // Moving backwards,
			}

			// @params compareIndex now denotes proper place for numbers to be
			// sorted
			array[compareIndex] = numberToInsert;
		}
	}

	// Generate a random number out of the minimum and maximum
	public static int randInt(int min, int max) {
		Random random = new Random();
		int randomInt = random.nextInt((max - min) + 1) + min;
		return randomInt;
	}

	// Get a random array with numbers 1 and 1000
	public static int[] generateRandomArray(int size) {
		int[] numbers = new int[size];
		Random random = new Random();
		for (int i = 0; i < numbers.length; i++) {
			int randomInt = random.nextInt((1000 - 1) + 1) + 1;
			numbers[i] = randomInt;
		}
		return numbers;
	}

	public static void main(String[] args) {

		// Generate a 100 size array of random numbers
		int[] theRandomArray;

		// For 100 elements
		for (int i = 0; i < 5; i++) {
			theRandomArray = generateRandomArray(100);

			// Log the time taken for quick sorting
			long startTimeQuick = System.currentTimeMillis();
			quickSort(theRandomArray);
			long endTimeQuick = System.currentTimeMillis();
			long elapsedTimeQuick = endTimeQuick - startTimeQuick;
			System.out.println("The elapsed time for QuickSort for "
					+ theRandomArray.length + " elements " + "is: "
					+ elapsedTimeQuick + " ms");

			long startTimeInsertion = System.currentTimeMillis();
			insertionSort(theRandomArray);
			long endTimeInsertion = System.currentTimeMillis();
			long elapsedTimeInsertion = startTimeInsertion - endTimeInsertion;
			System.out.println("The elapsed time for InsertionSort for "
					+ theRandomArray.length + " elements " + "is: "
					+ elapsedTimeInsertion + " ms");

		}

		// For 10000 elements
		for (int i = 0; i < 5; i++) {
			theRandomArray = generateRandomArray(10000);

			// Log the time taken for quick sorting
			long startTimeQuick = System.currentTimeMillis();
			quickSort(theRandomArray);
			long endTimeQuick = System.currentTimeMillis();
			long elapsedTimeQuick = endTimeQuick - startTimeQuick;
			System.out.println("The elapsed time for QuickSort for "
					+ theRandomArray.length + " elements " + "is: "
					+ elapsedTimeQuick + " ms");

			long startTimeInsertion = System.currentTimeMillis();
			insertionSort(theRandomArray);
			long endTimeInsertion = System.currentTimeMillis();
			long elapsedTimeInsertion = startTimeInsertion - endTimeInsertion;
			System.out.println("The elapsed time for InsertionSort for "
					+ theRandomArray.length + " elements " + "is: "
					+ elapsedTimeInsertion + " ms");

		}

		// For 100000 elements
		for (int i = 0; i < 5; i++) {
			theRandomArray = generateRandomArray(100000);

			// Log the time taken for quick sorting
			long startTimeQuick = System.currentTimeMillis();
			quickSort(theRandomArray);
			long endTimeQuick = System.currentTimeMillis();
			long elapsedTimeQuick = endTimeQuick - startTimeQuick;
			System.out.println("The elapsed time for QuickSort for "
					+ theRandomArray.length + " elements " + "is: "
					+ elapsedTimeQuick + " ms");

			long startTimeInsertion = System.currentTimeMillis();
			insertionSort(theRandomArray);
			long endTimeInsertion = System.currentTimeMillis();
			long elapsedTimeInsertion = startTimeInsertion - endTimeInsertion;
			System.out.println("The elapsed time for InsertionSort for "
					+ theRandomArray.length + " elements " + "is: "
					+ elapsedTimeInsertion + " ms");

		}
	}

}
