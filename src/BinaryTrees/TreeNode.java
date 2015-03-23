package BinaryTrees;

import BinaryTrees.interfaces.Position;

public class TreeNode<E> implements Position<E> {
	
	private E element;
	
	private TreeNode<E> left, right, parent; // The Adjacent Nodes
	
	public TreeNode(E element, TreeNode<E> parent,
			TreeNode<E> left, TreeNode<E> right) {
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
	public TreeNode<E> getLeft() {
		return left;
	}
	
	// Sets the left child at this position
	@Override
	public void setLeft(TreeNode<E> left) {
		this.left = left;
	}
	
	// Returns the right child at this position
	@Override
	public TreeNode<E> getRight() {
		return right;
	}
	
	// Sets the right child at this position
	@Override
	public void setRight(TreeNode<E> right) {
		this.right = right;
	}
	
	// Gets the parent node
	@Override
	public TreeNode<E> getParent() {
		return parent;
	}
	
	// Sets the parent node
	@Override
	public void setParent(TreeNode<E> parent) {
		this.parent = parent;
	}
	
	public boolean isInternal() {
		return (this.getLeft() != null || this.getRight() != null);
	}
	
}
