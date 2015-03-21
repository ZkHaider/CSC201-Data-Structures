package BinaryTrees.interfaces;

public interface Position<E> {
	
	// Get the element
	public E getElement();
	
	// Set the element at the node
	public void setElement(E e);
	
	// Set the left child
	public void setLeft(Position<E> v);
		
	// Get the left child
	public Position<E> getLeft();
		
	// Set the right child
	public void setRight(Position<E> v);
		
	// Get the right child
	public Position<E> getRight();
		
	// Set the parent node
	public void setParent(Position<E> v);
		
	// Get the parent node
	public Position<E> getParent();

}
