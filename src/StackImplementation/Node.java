package StackImplementation;

/*
 * @author Haider Khan
 * Date: 2-18-15
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 * Description: Node class for the Doubly LinkedList which will 
 * 				utilize a sentinel node.
 *  * References: Data Structures and Algorithms in Java, 5th Edition
 */


public class Node<T> {
	
	// Our pointers to the next or previous nodes
	private Node<T> next, previous;
	private T element;
	
	// Our constructor for creating a node and with fields
	public Node(T element, Node<T> previous, Node<T> next) {
		this.element = element;
		this.previous = previous;
		this.next = next;
	}
	
	// Getters and Setters for our Node
	public T getElement() {
		return element;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
	public Node<T> getPrevious() {
		return this.previous;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
