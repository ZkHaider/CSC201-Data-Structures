package ComputerParts;

public class SortedPartsList {
	
	protected PartsNode<ComputerPart> head; // The very top of the linkedlist
	protected PartsNode<ComputerPart> tail; // The very end of the linkedlist
	protected long size; // Number of nodes in the linkedlist
	
	
	public SortedPartsList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	// Add the first item in the linkedlist 
	public void addFirst(ComputerPart item) {
		
		boolean isComputerPart = item instanceof ComputerPart;
		
		// Do a check on item using the equals method in the base class
		if (!isComputerPart) {
			throw new IllegalArgumentException("This is not a computer part");
		}
		
		if (tail == null) {
			
			PartsNode<ComputerPart> node = new PartsNode<ComputerPart>();
			node.setComputerPart(item);
			tail = node;
		}
		
		//Add to the front of the list, that is 
		
		// Insert the node that you need
		PartsNode<ComputerPart> node = new PartsNode<ComputerPart>();
		node.setComputerPart(item);
		
		node.setNextNode(head);
		head = node; // Change memory allocation, and let java take care via garbage collection
		
		size++;
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
	
	// Returns a string which gives description for the object and returns the list of items
	public String toString() {
		
		String output = "This is a SinglyLinkedList with the following items:\n" + "\n";
		
		PartsNode<ComputerPart> current = head;
		
		// Do a check if the size of the list is 1
		if (size == 0) {
			
			throw new NoSuchPartException("The list is empty");
			
		} else if (size == 1) {
			
			return output += current.getComputerPart().description;
			
		} else {
			
			for (int i = 0; i < size; i++) {
				output += current.getComputerPart().description + " and its cost is " +
							current.getComputerPart().cost + "\n";
				
				current = current.getNextNode();
			}
		
		}
		
		return output;
	}

	public double averagePrice() {
		
		double total = 0;
		int count = 0;
		double average = 0;
		
		if (head == null) {
			throw new NoSuchPartException("The list is empty");
		} else {
			
			PartsNode<ComputerPart> current = head;
		
			while (current.getNextNode() != null) {
				// Get the cost from the current node
				total += current.getComputerPart().cost;
				
				// Grab the next node
				current = current.getNextNode();
				
				// Increment the count up by one
				count++;
			}
			
			average = total / count;
			
		}
		
		return average;
	}
	
	
	public static void main(String[] args) {
		
		// Create a new sortedlinkedlsit 
		SortedPartsList list = new SortedPartsList();
		
		//list.averagePrice(); // Should return NoSuchPartException
		
		/***** TEST PASS *****/
		
		// Create some computer part objects and add them to the list
		
		RAM ram = new RAM(300, 4000);
		ram.setCost(50.00);
		
		TapeDrive tapeDrive = new TapeDrive(200, 6000, 2);
		tapeDrive.setCost(60.00);
		
		HardDisk hardDisk = new HardDisk(200, 4000);
		hardDisk.setCost(70.00);
		
		GraphicsCard graphicsCard = new GraphicsCard(300, 7000);
		graphicsCard.setCost(280.00);
		
		
		
		list.addFirst(ram);
		list.addFirst(tapeDrive);
		list.addFirst(hardDisk);
		list.addFirst(graphicsCard);
		
		System.out.println(list.toString());
		
		
	}
	
}
