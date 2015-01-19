package Examples;
import java.util.Arrays;

/*
 * Name: Haider Khan
 * Date: 1-17-15
 * "I pledge that I have acted honorably" - Haider Khan
 * CSC 202 - Data Structures
 * 
 * Purpose: To setup an ExampleTest object that will setup a example array
 * 			In this class you can add an example object, copy the array, and
 * 			Sort the examples array with comparable and selection sort.
 */

public class ExampleTest {

	// Count final constant 
	public static final int COUNT = 10;
	
	// Data structure for holding example objects
	private Example[] examples;
	private Example[] newExamples;
	
	// Default constructor for creating a 10 size example array
	public ExampleTest() {
		examples = new Example[10];
	}
	
	// Another constructor that takes in a parameter of an examples array and stores it
	public ExampleTest(Example[] examples) {
		if (examples.length == 0) {
			throw new RuntimeException("Array of examples cannot be 0");
		} else {
			this.examples = examples;
		}
	}
	
	public Example[] getExamples() {
		return examples;
	}
	
	public void add(Example example) {
		// First thing we would need to determine is whether or not an array is full
		boolean isFull = isArrayFull(examples);
		
		if (isFull == true) {
			examples = copyArray(examples, example);
		} else {
			for (int i = 0; i < examples.length; i++) {
				if (examples[i] == null) {
					examples[i] = example;
					break;
				}
			}
 		}
		
	}
	
	public boolean isArrayFull(Example[] examples) {
		// Iterate through the array
		for (Example example : examples) {
			if (example == null) {
				return false;
			}
		}
		return true;
	}
	
	private Example[] copyArray(Example[] examples, Example example) {
		
		newExamples = new Example[examples.length + 1];
		
		for (int i = 0; i < examples.length; i++) {
			newExamples[i] = examples[i];
		}
		
		newExamples[newExamples.length - 1] = example;
		
		examples = new Example[newExamples.length];
		
		for (int i = 0; i < newExamples.length; i++){
			examples[i] = newExamples[i];
		}
		
		return examples;
	}
	
	private void selectionSort(Example[] array) {
		
		if (array.length == 1) {
			System.out.println("Array only contains 1 element");
		} else {
		
			for (int i = 0; i < array.length; i++) {
				int index = i;
				for (int j = i + 1; j < array.length; j++) {
					if (array[j].compareTo(array[index]) < 0) {
						index = j;
					}
				}
				
				// Change example 
				Example temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
			
			examples = array;
		
		}
	}
	
	public static void main(String[] args) {
		
		/********** TEST CASE 1 *************/
		
		// Setup Default constructor
		ExampleTest exampleTest = new ExampleTest();
		
		System.out.println(exampleTest.getExamples().length); // This should be 10 for default
		
		// Test Case: PASS
		
		/********** TEST CASE 2 ************/
		
		// Setup array of length 4
		Example[] secondExamples = {new Example(2, "Joe"), new Example(1, "Larry"), 
									new Example(4, "Harry"), new Example(2, "Moe") };
		
		ExampleTest exampleTest2 = new ExampleTest(secondExamples);
	
		System.out.println(exampleTest2.getExamples().length); // This should be 4
		
		// Check the add method on a full array
		Example example2 = new Example(3, "Grace");
		exampleTest2.add(example2); // Works and adds an extra object to array
		
		System.out.println(exampleTest2.getExamples().length); // Should be 5
		
		// Test Case: PASS
		
		/********** TEST CASE 3 ************/
		
		// Use test case 1 and add an example to it
		Example addExample = new Example(30
				, "Haider");
		exampleTest.add(addExample); // Add to index 0
		System.out.println(exampleTest.getExamples()[0].getCount());
		
		// Test Case: PASS
		
		/********** TEST CASE 4 ************/
		
		// Run the selection sort algorithm on exampleTest3
		exampleTest2.selectionSort(exampleTest2.getExamples());
		
		for (int i = 0; i < exampleTest2.getExamples().length; i++) {
			System.out.println("The name of index [" + i + "] is " + 
						exampleTest2.getExamples()[i].getName() + " and the count is "
						+ exampleTest2.getExamples()[i].getCount());
		}
		
		/********** TEST CASE 5 ***********/
		
		// Run the comparable sort
		
		Arrays.sort(exampleTest2.getExamples());
		
		for (int i = 0; i < exampleTest2.getExamples().length; i++) {
			System.out.println("The name of index [" + i + "] is " + 
						exampleTest2.getExamples()[i].getName() + " and the count is "
						+ exampleTest2.getExamples()[i].getCount());
		}
		
		// Test Case: PASS
		
		/********** TEST CASE 6 ***********/
		
		Example[] zeroArray = new Example[0];
		
		// Try to make an exampletest of example array of 0
		ExampleTest zeroTest = new ExampleTest(zeroArray);
		
		// Throws RunTimeException like expected
		
		// Test Case: PASS
		
	}
	
}
