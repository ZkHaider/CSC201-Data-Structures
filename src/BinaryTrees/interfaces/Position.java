package BinaryTrees.interfaces;

import BinaryTrees.TreeNode;

public interface Position<E> {
	
	// Get the element
	public E getElement();
	
	// Set the element at the node
	public void setElement(E e);
	
	// Set the left child
	public void setLeft(TreeNode<E> v);
		
	// Get the left child
	public TreeNode<E> getLeft();
		
	// Set the right child
	public void setRight(TreeNode<E> v);
		
	// Get the right child
	public TreeNode<E> getRight();
		
	// Set the parent node
	public void setParent(TreeNode<E> v);
		
	// Get the parent node
	public TreeNode<E> getParent();

}
