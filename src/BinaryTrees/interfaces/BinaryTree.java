package BinaryTrees.interfaces;

import BinaryTrees.TreeNode;


public interface BinaryTree<E> extends Tree<E> {
	
	// Check if the node has a right branch (TreeNode)
	public boolean hasRight(TreeNode<E> v) throws Exception;
	
	// Check if the node has a left branch (TreeNode)
	public boolean hasLeft(TreeNode<E> v) throws Exception;

	// Returns the left child of a node
	public TreeNode<E> right(TreeNode<E> v) throws Exception;
	
	// Returns the right child of a node
	public TreeNode<E> left(TreeNode<E> v) throws Exception;

	// Check is the node is the root
	public boolean isRoot(TreeNode<E> v) throws Exception;

	// Check if this node is external
	public boolean isExternal(TreeNode<E> v);

	// Check if this node is internal
	public boolean isInternal(TreeNode<E> v) throws Exception;

	// Get the children of the node v
	public Iterable<TreeNode<E>> children(TreeNode<E> v) throws Exception;

	// Get the parent of the node v
	public TreeNode<E> parent(TreeNode<E> v) throws Exception;

	// Replace the node v
	public E replace(TreeNode<E> v, E e) throws Exception;

}
