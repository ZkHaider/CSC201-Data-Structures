package BinaryTrees.interfaces;

import java.util.Iterator;

public interface Tree<E> {

	// Return the number of nodes in the tree
	public int size();
	
	// Returns whether the tree is empty
	public boolean isEmpty();
	
	// Returns an iterator of the elements stored in the tree
	public Iterator<E> iterator() throws Exception;
	
	// Returns an iterable collection of the nodes
	public Iterable<Position<E>> positions() throws Exception;
	
	// Replaces the element at a given node
	public E replace(Position<E> v, E e) throws IllegalArgumentException, Exception;
	
	// Returns the parent of this node
	public Position<E> parent(Position<E> v) throws Exception;
	
	// Returns the parent of this node
	public Position<E> root() throws Exception;
	
	// Returns an Iterable Collection of the children of a given node
	public Iterable<Position<E>> children(Position<E> v) throws Exception;
	
	// Returns whether the given node is internal or not
	public boolean isInternal(Position<E> v) throws Exception;
	
	// Returns whether the given node is external or not
	public boolean isExternal(Position<E> v);
	
	// Returns whether the node is the root node or not
	public boolean isRoot(Position<E> v) throws Exception;

	public Position<E> left(Position<E> v) throws Exception;
	
}
