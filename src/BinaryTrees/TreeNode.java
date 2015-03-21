package BinaryTrees;

import BinaryTrees.interfaces.Position;

public class TreeNode<E> implements Position<E> {
	
	private E element;
	
	private Position<E> left, right, parent; // The Adjacent Nodes
	
	public TreeNode(E element, Position<E> parent,
			Position<E> left, Position<E> right) {
		setElement(element);
		setParent(parent);
		setLeft(left);
		setRight(right);
	}
	
	// Returns the Element Stored at this position
	@Override
	public E getElement() {
		return element;
	}
	
	// Sets the element at this position
	@Override
	public void setElement(E element) {
		this.element = element;
	}
	
	// Returns the left child of this position
	@Override
	public Position<E> getLeft() {
		return left;
	}
	
	// Sets the left child at this position
	@Override
	public void setLeft(Position<E> left) {
		this.left = left;
	}
	
	// Returns the right child at this position
	@Override
	public Position<E> getRight() {
		return right;
	}
	
	// Sets the right child at this position
	@Override
	public void setRight(Position<E> right) {
		this.right = right;
	}
	
	// Gets the parent node
	@Override
	public Position<E> getParent() {
		return parent;
	}
	
	// Sets the parent node
	@Override
	public void setParent(Position<E> parent) {
		this.parent = parent;
	}

}
