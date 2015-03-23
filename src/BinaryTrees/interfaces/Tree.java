package BinaryTrees.interfaces;

import java.util.Iterator;

import BinaryTrees.TreeNode;

public interface Tree<E> {

	// Return the number of nodes in the tree
	public int size();
	
	// Returns whether the tree is empty
	public boolean isEmpty();
	
	// Returns an iterator of the elements stored in the tree
	public Iterator<E> iterator() throws Exception;
	
	// Returns an iterable collection of the nodes
	public Iterable<TreeNode<E>> positions() throws Exception;
	
	// Replaces the element at a given node
	public E replace(TreeNode<E> v, E e) throws IllegalArgumentException, Exception;
	
	// Returns the parent of this node
	public TreeNode<E> parent(TreeNode<E> v) throws Exception;
	
	// Returns the parent of this node
	public TreeNode<E> root() throws Exception;
	
	// Returns an Iterable Collection of the children of a given node
	public Iterable<TreeNode<E>> children(TreeNode<E> v) throws Exception;
	
	// Returns whether the given node is internal or not
	public boolean isInternal(TreeNode<E> v) throws Exception;
	
	// Returns whether the given node is external or not
	public boolean isExternal(TreeNode<E> v);
	
	// Returns whether the node is the root node or not
	public boolean isRoot(TreeNode<E> v) throws Exception;

	public TreeNode<E> left(TreeNode<E> v) throws Exception;
	
}
