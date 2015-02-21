package StackImplementation;

import java.util.EmptyStackException;

/*
 * @author Haider Khan
 * Date: 2-18-15
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 * Description: MyStackFunctions class that uses static
 * 				methods to implement sumNegative, clean
 * 				, and a main method to test. 
 * References: Data Structures and Algorithms in Java, 5th Edition
 */

public class MyStackFunctions {

	public static final String SPACE = " ";

	public static int sumNegatives(MyStack<Integer> stack) {
		// Check size for 0
		if (stack.isEmpty()) {
			throw new EmptyStackException();
		}

		MyStack<Integer> tempStack = new MyStack<Integer>();

		int sum = 0;
		int size = stack.getSize();

		for (int i = 0; i < size; i++) {
			int topValue = stack.pop();
			tempStack.push(topValue);
			if (topValue < 0) {
				sum += topValue;
			}
		}

		for (int i = 0; i < size; i++) {
			System.out.println(tempStack.peek());
			stack.push(tempStack.pop());
		}

		return sum;
	}

	public static void clean(MyStack<String> stringStack) {
		if (stringStack.isEmpty()) {
			throw new EmptyStackException();
		}

		int size = stringStack.getSize();
		MyStack<String> tempStack = new MyStack<String>();

		for (int i = 0; i < size; i++) {
			String[] tempString = stringStack.pop().split(SPACE);

			for (int j = 0; j < tempString.length; j++) {
				tempStack.push(tempString[j]);
			}
		}

		int tempSize = tempStack.getSize();

		for (int i = 0; i < tempSize; i++) {
			stringStack.push(tempStack.pop());
		}
	}

	public static void main(String[] args) {

		MyStack<Integer> integerStack = new MyStack<Integer>();

		// Declare a Negative Int Stack of -1, -2, -3, -4, -5
		for (int i = 0; i < 5; i++) {
			int negativeValue = -i + -1;
			integerStack.push(negativeValue);
			System.out.println(integerStack.peek());
		}

		// Should print out -15 --- TESTED AND WORKS
		System.out.println(MyStackFunctions.sumNegatives(integerStack));

		// Should print out 5 --- TESTED AND WORKS
		System.out.println(integerStack.getSize());

		MyStack<Integer> integerStack2 = new MyStack<>();

		integerStack2.push(-2);
		integerStack2.push(10);
		integerStack2.push(-5);
		integerStack2.push(100);
		integerStack2.push(-3);
		integerStack2.push(-30);

		// Should be -40 -- TESTED AND WORKS
		System.out.println(MyStackFunctions.sumNegatives(integerStack2));

		MyStack<String> stringStack = new MyStack<String>();

		stringStack.push("I am bob");
		stringStack.push("and I");
		stringStack.push("work");
		stringStack.push("at the");
		stringStack.push("local home depot");

		MyStackFunctions.clean(stringStack);

		// Should clean up any string stack by separating words -- TESTED AND
		// WORKS
		int size = stringStack.getSize();
		for (int i = 0; i < size; i++) {
			System.out.println(stringStack.pop());
		}

		MyStack<String> stringStack2 = new MyStack<String>();

		stringStack2.push("awesome badass");
		stringStack2.push("i am a cat");
		stringStack2.push("blue shirt");
		stringStack2.push("i am a badass cat");
		stringStack2.push("i drink coffee");

		MyStackFunctions.clean(stringStack2);

		// Should clean up any string stack by separating words -- TESTED AND
		// WORKS
		int size2 = stringStack2.getSize();
		for (int i = 0; i < size2; i++) {
			System.out.println(stringStack2.pop());
		}

	}

}
