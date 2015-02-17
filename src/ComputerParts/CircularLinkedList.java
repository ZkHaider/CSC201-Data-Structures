
package ComputerParts;


public class CircularLinkedList {


	// Node class with data, next, and previous
	// Circular, use sentinal 

	PartsNode<ComputerPart> head = new PartsNode<ComputerPart>();
	int size = 0;

	public CircularLinkedList() {
		head.setNextNode(head);
		// Set previous node to head as well
		
	}

	public void insert(ComputerPart part, int index) {

		if (index < 0 || index > size) {
			throw new NoSuchPartException("The index cannot be greater than or less than the size");
		}

		PartsNode<ComputerPart> current = head;

		for (int i = 0; i < index; i++) {
			current = current.getNextNode();
		}

		PartsNode<ComputerPart> newNode = new PartsNode<ComputerPart>();
		newNode.setComputerPart(part);
		newNode.setNextNode(current.getNextNode());
		//newNode.setPreviousNode(current);
		//current.getNextNode().setPreviousNode(newNode);
		//current.setNextNode(newNode);
		
	}
}