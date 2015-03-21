package BinaryTrees.interfaces;


public interface BinaryTree<E> extends Tree<E> {
	
	// Returns the left child of a node.
	public Position<E> left(Position<E> v) throws Exception;
	
	// Returns the right node
	public Position<E> right(Position<E> v);
	
	// Checks if the node has a left branch
	public boolean hasLeft(Position<E> v) throws Exception;
	
	// Checks if the node has a right branch
	public boolean hasRight(Position<E> v);

	// Replace the node here
	public E replace(Position<E> v, E e) throws Exception;
	
	

}
