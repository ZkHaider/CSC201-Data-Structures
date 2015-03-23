package BinaryTrees.interfaces;

import BinaryTrees.TreeNode;

public interface TreePosition<E> extends Position<E> {
	
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

	@Override
	public void setElement(E element);
	
	@Override
	public E getElement();
	
}
