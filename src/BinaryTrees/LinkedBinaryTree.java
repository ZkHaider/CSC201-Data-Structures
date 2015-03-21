package BinaryTrees;

/*
 * Name: Haider Khan
 * @author ZkHaider
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 * Class: CSC 201 - Data Structures
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import BinaryTrees.interfaces.BinaryTree;
import BinaryTrees.interfaces.Position;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
	
	// Global Variables
	protected Position<E> root; // The reference to the root node, (Head Node)
	protected int size; // The number of nodes present in this Data Structures
	
	// Creates an empty Binary Tree
	public LinkedBinaryTree() {
		root = null; // Start with an empty tree
		size = 0;
	}
	

	/**** Implemented Methods ****/ 
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Iterator<E> iterator() throws Exception {
		Iterable<Position<E>> positions = positions();
		ArrayList<E> elements = new ArrayList<>();
		for (Position<E> pos : positions)
			elements.add(pos.getElement());
		return elements.iterator(); // An iterator of elements
	}

	@Override
	public Iterable<Position<E>> positions() throws Exception {
		ArrayList<Position<E>> positions = new ArrayList<>();
		if (size != 0) {
			preorderPositions(root(), positions); // Assigns positions in preorder
		}
		return positions;
	}

	@Override
	public E replace(Position<E> v, E e) throws Exception {
		Position<E> vv = checkPosition(v);
		E temp = v.getElement();
		vv.setElement(e);
		return temp;
	}

	@Override
	public Position<E> parent(Position<E> v) throws Exception {
		Position<E> vv = checkPosition(v);
		Position<E> parentPos = vv.getParent();
		if (parentPos == null)
			throw new Exception("Parent is null");
		return parentPos;
	}

	@Override
	public Position<E> root() throws Exception {
		if (root == null)
			throw new Exception("Root is null");
		return root;
	}

	@Override
	public Iterable<Position<E>> children(Position<E> v) throws Exception {
		ArrayList<Position<E>> children = new ArrayList<>();
		if (hasLeft(v))
			children.add(left(v));
		if (hasRight(v))
			children.add(right(v));
		return children;
	}

	@Override
	public boolean isInternal(Position<E> v) throws Exception {
		checkPosition(v); // An auxillary method
		return (hasLeft(v) || hasRight(v));
	}

	@Override
	public boolean isExternal(Position<E> v) {
		return false;
	}

	@Override
	public boolean isRoot(Position<E> v) throws Exception {
		checkPosition(v); // Auxillary Method
		return (v == root());
	}

	@Override
	public Position<E> left(Position<E> v) throws Exception {
		Position<E> vv = checkPosition(v);
		Position<E> leftPosition = vv.getLeft();
		if (leftPosition == null)
			throw new Exception("No left child");
		return leftPosition;
	}

	@Override
	public Position<E> right(Position<E> v) {
		return null;
	}

	@Override
	public boolean hasLeft(Position<E> v) throws Exception {
		Position<E> vv = checkPosition(v);
		return (vv.getLeft() != null);
	}

	@Override
	public boolean hasRight(Position<E> v) {
		return false;
	}
	
	// Additional accessor method returns the siblings of the node
	public Position<E> sibling(Position<E> v) throws Exception {
		Position<E> vv = checkPosition(v);
		Position<E> parentPos = vv.getParent();
		if (parentPos != null) {
			Position<E> sibPos;
			Position<E> leftPos = parentPos.getLeft();
			if (leftPos == null) {
				sibPos = parentPos.getRight();
			} else {
				sibPos = parentPos.getLeft();
			}
			if (sibPos != null) {
				return sibPos;
			}
		}
		throw new Exception("No sibling present");
	}
	
	// Additional Update Methods
	// Add a rootmethod to an empty tree
	public Position<E> addRoot(E e) throws Exception {
		if (!isEmpty()) {
			throw new Exception("Tree already has a root");
		}
		
		size = 1;
		root = createNode(e, null, null, null);
		return root;
	}
	
	// Insert a left child at a given node
	public Position<E> insertLeft(Position<E> v, E e) throws Exception {
		Position<E> vv = checkPosition(v);
		Position<E> leftPos = vv.getLeft();
		if (leftPos != null) {
			throw new Exception("Node already has a left child");
		}
		Position<E> ww = createNode(e, vv, null, null);
		vv.setLeft(ww);
		size++;
		return ww;
	}
	
	// Remove a node with zero or one child
	public E remove(Position<E> v) throws Exception {
		Position<E> vv = checkPosition(v);
		Position<E> leftPos = vv.getLeft();
		Position<E> rightPos = vv.getRight();
		if (leftPos != null && rightPos != null) {
			throw new Exception("Cannot remove a node with two children");
		}
		Position<E> ww; // The only child of v, if any
		if (leftPos != null)
			ww = leftPos;
		else if (rightPos != null)
			ww = rightPos;
		else // v is a leaf
			ww = null;
		if (vv == root) {
			if (ww != null)
				ww.setParent(null);
			root = ww;
		} else {
			// vv is not the root
			Position<E> uu = vv.getParent();
			if (vv == uu.getLeft())
				uu.setLeft(ww);
			else 
				uu.setRight(ww);
			if (ww != null)
				ww.setParent(uu);
		}
		size--;
		return v.getElement();
	}
	
	// Attach two trees to be sub trees of an external node
	public void attach(Position<E> v, BinaryTree<E> bt1, BinaryTree<E> bt2) throws Exception {
		Position<E> vv = checkPosition(v);
		if (isInternal(v))
			throw new Exception("Cannot attach from internal node");
		int newSize = size + bt1.size() + bt2.size();
		if (!bt1.isEmpty()) {
			Position<E> root1 = checkPosition(bt1.root());
			vv.setLeft(root1);
			root1.setParent(vv); // bt1 should be invalidated
		}
		if (!bt2.isEmpty()) {
			Position<E> root2 = checkPosition(bt2.root());
			vv.setRight(root2);
			root2.setParent(vv); // bt2 should be in
		}
		size = newSize;
	}
	
	// If v is a BinaryNode cast to Position<E> else throw an exception
	protected Position<E> checkPosition(Position<E> v) throws Exception {
		if (v == null || !(v instanceof Position)) {
			throw new Exception("The position is invalid");
		}
		return (Position<E>) v;
	}
	
	// Create a new binary tree node
	protected Position<E> createNode(E element, Position<E> parent, 
			Position<E> left, Position<E> right) {
		return new TreeNode<E>(element, parent, left, right);
	}
	
	// Creates a list storing the nodes in the subtree of a node, 
	// ordered according to the preorder transversal of the subtree
	protected void preorderPositions(Position<E> v, ArrayList<Position<E>> positions)
		throws Exception {
		positions.add(v);
		if (hasLeft(v)) {
			preorderPositions(left(v), positions); // recurse on the left child
		} 
		if (hasRight(v)) {
			preorderPositions(right(v), positions); // recurse on the right child
		}
	}

}
