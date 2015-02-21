package StackImplementation;

import java.util.EmptyStackException;

/*
 * @author Haider Khan 
 * Date: 2-16-15
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 * Description: Implementation of a Stack data structure, utilizing 
 * 				generics to allow the user to implement any kind of 
 * 				data type (classes, objects, etc.) as parameters of 
 * 				our implementation of the stack. Therefore we will
 * 				specify a Type placeholder <T>
 * References: Data Structures and Algorithms in Java, 5th Edition
 */

public class MyStack<T> {

	// The top of the stack
	private Node<T> head, tail;
	private int size;

	// Make an empty stack head == null and size is zero
	public MyStack() {

		/*
		 * Sample Drawing of our empty double linked list
		 * 
		 * -------- -------- - Head - - Tail - -------- .setNext() -------- - **
		 * - ---------> - ** - -------- -------- - - - .setPrevious() -
		 * -----------<----------
		 */

		head = new Node<T>(null, null, null);
		// Make head and tail point to each other in this empty linkedlist
		tail = new Node<T>(null, head, null);
		size = 0;
		head.setNext(tail);
	}

	// Return whether the list is empty or not
	public boolean isEmpty() {
		return (size == 0);
	}

	public void push(T t) {
		Node<T> newNode = new Node<T>(t, null, null);
		Node<T> w = head.getNext();
		newNode.setPrevious(head);
		newNode.setNext(w);
		w.setPrevious(newNode);
		head.setNext(newNode);
		size++;
	}

	public T pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		T topElement = head.getNext().getElement();
		head.setNext(head.getNext().getNext());; // Let java garbage collect the previous head
								// node
		size--;
		return topElement;
	}

	// Return node before a given node
	public T getPrevious(Node<T> node) throws IllegalArgumentException {
		if (node == head) {
			throw new IllegalArgumentException(
					"Cannot see node before the header");
		}
		return node.getPrevious().getElement();
	}

	// Return the node after the given node n
	public T getNext(Node<T> node) throws IllegalArgumentException {
		if (node == tail) {
			throw new IllegalArgumentException("Cannot go back the tail");
		}
		return node.getNext().getElement();
	}

	// Get the top Node
	public T peek() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException("The List is empty");
		}
		// Get the first node if not empty
		return head.getNext().getElement();
	}

	// Return the size of the list |e|
	public int getSize() {
		return size;
	}
}
