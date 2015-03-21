package BinaryTrees.interfaces;

public interface TreePosition<E> extends Position<E> {
	
	// Set the left child
	public void setLeft(TreePosition<E> v);
	
	// Get the left child
	public TreePosition<E> getLeft();
	
	// Set the right child
	public void setRight(TreePosition<E> v);
	
	// Get the right child
	public TreePosition<E> getRight();
	
	// Set the parent node
	public void setParent(TreePosition<E> v);
	
	// Get the parent node
	public TreePosition<E> getParent();

	@Override
	public void setElement(E element);
	
	@Override
	public E getElement();
	
}
