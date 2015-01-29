package ComputerParts;

public class SortedPartsList {
	
	protected PartsNode<ComputerPart> head; // The very top of the linkedlist
	protected long size; // Number of nodes in the linkedlist
	
	
	public SortedPartsList() {
		head = null;
		size = 0;
	}
	
	// Add the first item in the linkedlist 
	public void addFirst(ComputerPart item) {
		
		// Do a check on item using the equals method in the base class
		if (!item.isComputerPart(item)) {
			throw new IllegalArgumentException("This is not a compter part");
		}
		
		//Add to the front of the list, that is 
		
		// Insert the node that you need
		PartsNode<ComputerPart> node = new PartsNode<ComputerPart>();
		node.setComputerPart(item);
		
		node.setNextNode(head);
		head = node; // Change memory allocation, and let java take care via garbage collection
		
		// This comes out to be O(1) 
	}
	
	// Add to the end of the linkedlist
	public void addLast(ComputerPart item) {
		
		if (head == null) {
			// If the list is already null then just add the first item
			addFirst(item);
			return;
		} else {
			// Make new node
			PartsNode<ComputerPart> node = new PartsNode<ComputerPart>();
			// Iterate to the last node since it's a linkedlist and there is no size
			PartsNode<ComputerPart> current = head;
			
			while (current.getNextNode() != null) {
				// Iterate to the next
				current = current.getNextNode();
				
				// Insert after the current
				current.setNextNode(node);
			}
		}
	}
	
	public ComputerPart removeFirst() {
		
		if (head == null) {
			throw new IllegalArgumentException("The list is empty");
		}
		
		ComputerPart data = head.getComputerPart(); // Rely here on garbage collection
		
		head = head.getNextNode();
		
		return data;
	}
	
	public ComputerPart removeLast() {
		
		// Create another temporary node
		PartsNode<ComputerPart> current = head;
		
		// We need to handle the special case, which should be a second special case
		if (head.getNextNode() == null) {
			head = null;
		} else {
			while (current.getNextNode().getNextNode() != null) {
				current = current.getNextNode();
				current.setNextNode(null); // Set the last thing to null
			}
		}
		
		return current.getComputerPart();
	}

}
