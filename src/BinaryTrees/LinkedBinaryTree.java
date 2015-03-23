package BinaryTrees;

/*
 * Name: Haider Khan
 * @author ZkHaider
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 * Class: CSC 201 - Data Structures
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import BinaryTrees.interfaces.BinaryTree;
import BinaryTrees.interfaces.Position;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
	
	// Global Variables
	protected TreeNode<E> root; // The reference to the root node, (Head Node)
	protected int size = 0; // The number of nodes present in this Data Structures
	
	// Creates an empty Binary Tree
	public LinkedBinaryTree() {
		root = new TreeNode<E>(null, null, null, null); // Start with an empty tree
		size++;
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
		Iterable<TreeNode<E>> positions = positions();
		ArrayList<E> elements = new ArrayList<>();
		for (TreeNode<E> pos : positions)
			elements.add(pos.getElement());
		return elements.iterator(); // An iterator of elements
	}

	@Override
	public Iterable<TreeNode<E>> positions() throws Exception {
		ArrayList<TreeNode<E>> positions = new ArrayList<>();
		if (size != 0) {
			preorderPositions(root(), positions); // Assigns positions in preorder
		}
		return positions;
	}

	@Override
	public E replace(TreeNode<E> v, E e) throws Exception {
		TreeNode<E> vv = checkPosition(v);
		E temp = v.getElement();
		vv.setElement(e);
		return temp;
	}

	@Override
	public TreeNode<E> parent(TreeNode<E> v) throws Exception {
		TreeNode<E> vv = checkPosition(v);
		TreeNode<E> parentPos = (TreeNode<E>) vv.getParent();
		if (parentPos == null)
			throw new Exception("Parent is null");
		return parentPos;
	}

	@Override
	public TreeNode<E> root() throws Exception {
		if (root == null)
			throw new Exception("Root is null");
		return root;
	}

	@Override
	public Iterable<TreeNode<E>> children(TreeNode<E> v) throws Exception {
		ArrayList<TreeNode<E>> children = new ArrayList<>();
		if (hasLeft(v))
			children.add(left(v));
		if (hasRight(v))
			children.add(right(v));
		return children;
	}

	@Override
	public boolean isInternal(TreeNode<E> v) throws Exception {
		checkPosition(v); // An auxillary method
		return (hasLeft(v) || hasRight(v));
	}

	@Override
	public boolean isExternal(TreeNode<E> v) {
		return false;
	}

	@Override
	public boolean isRoot(TreeNode<E> v) throws Exception {
		checkPosition(v); // Auxillary Method
		return (v == root());
	}

	@Override
	public TreeNode<E> left(TreeNode<E> v) throws Exception {
		TreeNode<E> vv = checkPosition(v);
		TreeNode<E> leftPosition = (TreeNode<E>) vv.getLeft();
		if (leftPosition == null)
			throw new Exception("No left child");
		return leftPosition;
	}

	@Override
	public TreeNode<E> right(TreeNode<E> v) {
		return null;
	}

	@Override
	public boolean hasLeft(TreeNode<E> v) throws Exception {
		TreeNode<E> vv = checkPosition(v);
		return (vv.getLeft() != null);
	}

	@Override
	public boolean hasRight(TreeNode<E> v) throws Exception {
		TreeNode<E> vv = checkPosition(v);
		return (vv.getRight() != null);
	}
	
	// Additional accessor method returns the siblings of the node
	public TreeNode<E> sibling(TreeNode<E> v) throws Exception {
		TreeNode<E> vv = checkPosition(v);
		TreeNode<E> parentPos = (TreeNode<E>) vv.getParent();
		if (parentPos != null) {
			TreeNode<E> sibPos;
			TreeNode<E> leftPos = (TreeNode<E>) parentPos.getLeft();
			if (leftPos == null) {
				sibPos = (TreeNode<E>) parentPos.getRight();
			} else {
				sibPos = (TreeNode<E>) parentPos.getLeft();
			}
			if (sibPos != null) {
				return sibPos;
			}
		}
		throw new Exception("No sibling present");
	}
	
	// Additional Update Methods
	// Add a rootmethod to an empty tree
	public TreeNode<E> addRoot(E e) throws Exception {
		if (!isEmpty()) {
			throw new Exception("Tree already has a root");
		}
		
		size = 1;
		root = createNode(e, null, null, null);
		return root;
	}
	
	// Insert a left child at a given node
	public TreeNode<E> insertLeft(TreeNode<E> v, E e) throws Exception {
		TreeNode<E> vv = checkPosition(v);
		TreeNode<E> leftPos = (TreeNode<E>) vv.getLeft();
		if (leftPos != null) {
			throw new Exception("Node already has a left child");
		}
		TreeNode<E> ww = createNode(e, vv, null, null);
		vv.setLeft(ww);
		size++;
		return ww;
	}
	
	public TreeNode<E> insertRight(TreeNode<E> v, E e) throws Exception {
		TreeNode<E> vv = checkPosition(v);
		TreeNode<E> rightPos = (TreeNode<E>) vv.getRight();
		if (rightPos != null) {
			throw new Exception("Node already has a right child");
		}
		TreeNode<E> ww = createNode(e, vv, null, null);
		vv.setRight(ww);
		size++;
		return ww;
	} 
	
	// Remove a node with zero or one child
	public E remove(TreeNode<E> v) throws Exception {
		TreeNode<E> vv = checkPosition(v);
		TreeNode<E> leftPos = (TreeNode<E>) vv.getLeft();
		TreeNode<E> rightPos = (TreeNode<E>) vv.getRight();
		if (leftPos != null && rightPos != null) {
			throw new Exception("Cannot remove a node with two children");
		}
		TreeNode<E> ww; // The only child of v, if any
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
			TreeNode<E> uu = (TreeNode<E>) vv.getParent();
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
	public void attach(TreeNode<E> v, LinkedBinaryTree<E> bt1, LinkedBinaryTree<E> bt2) throws Exception {
		TreeNode<E> vv = checkPosition(v);
		if (isInternal(v))
			throw new Exception("Cannot attach from internal node");
		int newSize = size + bt1.size() + bt2.size();
		if (!bt1.isEmpty()) {
			TreeNode<E> root1 = checkPosition(bt1.root());
			vv.setLeft(root1);
			root1.setParent(vv); // bt1 should be invalidated
		}
		if (!bt2.isEmpty()) {
			TreeNode<E> root2 = checkPosition(bt2.root());
			vv.setRight(root2);
			root2.setParent(vv); // bt2 should be in
		}
		size = newSize;
	}
	
	// If v is a BinaryNode cast to Position<E> else throw an exception
	protected TreeNode<E> checkPosition(TreeNode<E> v) throws Exception {
		if (v == null)  {
			System.out.println("V null");
		} else if (!(v instanceof TreeNode)) {
			System.out.println("V is not an instance of TreeNode");
		}
		if (v == null || !(v instanceof TreeNode)) {
			throw new Exception("The position is invalid");
		}
		return (TreeNode<E>) v;
	}
	
	// Create a new binary tree node
	protected TreeNode<E> createNode(E element, TreeNode<E> parent, 
			TreeNode<E> left, TreeNode<E> right) {
		return new TreeNode<E>(element, parent, left, right);
	}
	
	// Creates a list storing the nodes in the subtree of a node, 
	// ordered according to the preorder transversal of the subtree
	protected void preorderPositions(TreeNode<E> v, ArrayList<TreeNode<E>> positions)
		throws Exception {
		positions.add(v);
		if (hasLeft(v)) {
			preorderPositions(left(v), positions); // recurse on the left child
		} 
		if (hasRight(v)) {
			preorderPositions(right(v), positions); // recurse on the right child
		}
	}
	
	public TreeNode<E> preOrderNext(TreeNode<E> v) {
		
		if (v.getLeft() != null)
			return v.getLeft();
		else if (v.getRight() != null) 
			return v.getRight();
		else {
			TreeNode<E> parent = v.getParent();
			TreeNode<E> child = v;
			while (parent != null && 
					(parent.getRight() == null || parent.getRight().equals(child))) {
				child = parent;
				parent = child.getParent();
			}
			if (parent == null) 
				return null;
			return parent.getRight();
				
		}
	}
	
	public TreeNode<E> inOrderNext(TreeNode<E> v) {
		
		// Get v's right child if it isn't null iterate through and get all left childs
		// return the child
		if (v.getRight() != null) {
			TreeNode<E> child = v.getRight();
			while (child.getLeft() != null) 
				child = child.getLeft();
			return child;
		} else {
			if (v.getParent() == null)
				return null;
			if (v.getParent().getLeft() != null && v.getParent().getLeft().equals(v))
				return v.getParent();
			else {
				TreeNode<E> parent = v.getParent();
				TreeNode<E> child = v;
				while (parent != null && 
						(parent.getRight() != null || parent.getRight().equals(child))) {
					child = parent;
					parent = child.getParent();
				}
				if (parent == null) 
					return null;
				return parent;
			}
		}
	}
	
	public TreeNode<E> postOrderNext(TreeNode<E> v) throws Exception {
		if (v.getParent() == null) 
			throw new Exception("Parent is null");
		if (v.getParent().getRight() != null && v.getParent().getRight().equals(v))
			return v.getParent();
		else {
			if (v.getParent().getRight() != null) {
				return v.getParent();
			}
			else {
				TreeNode<E> node = v.getParent().getRight();
				while (node.isInternal()) {
					if (node.getLeft() != null) {
						node = node.getLeft();
					} else {
						node = node.getRight();
					}
					return node;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		
		// Setup the LinkedBinaryTree, creates and empty root
		LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree<Integer>();
		System.out.println(linkedBinaryTree.root.getElement()); // Should print null
		
		// Set root node to a 10
		linkedBinaryTree.root().setElement(10);
		TreeNode<Integer> root = linkedBinaryTree.root();
		System.out.println(linkedBinaryTree.root.getElement()); // Should print 10
		
		// Create a new node and set as a left child
		linkedBinaryTree.insertLeft(root, 5);
		System.out.println(String.valueOf(linkedBinaryTree.hasLeft(root))); // Should return true
		System.out.println(String.valueOf(linkedBinaryTree.hasRight(root))); // Should return false
		
		// Create a new node and set as a right child
		linkedBinaryTree.insertRight(root, 7);
		System.out.println(String.valueOf(linkedBinaryTree.hasRight(root))); // Should return true
		
		
		/* Now we should have a binary tree with a root of 10, left child of 5, and a right child
		 * of 7.
		 */
		
		// Should return 5
		System.out.println(linkedBinaryTree.preOrderNext(linkedBinaryTree.root()).getElement());
		
		// Should return 7
		System.out.println(linkedBinaryTree.inOrderNext(linkedBinaryTree.root()).getElement());
		
		// Should return 10
		System.out.println(linkedBinaryTree.postOrderNext(linkedBinaryTree.root().getLeft()).getElement());
		
	}

}
