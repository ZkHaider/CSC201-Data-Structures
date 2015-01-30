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
	
	public void insert(ComputerPart part, int index) {
		// Inserts the specified element at the correct index 
		PartsNode<ComputerPart> tempNode = new PartsNode<ComputerPart>();
		PartsNode<ComputerPart> current = head;
		
		// Now iterate over to the index value or to the end of the list
		for (int i = 0; i < index && current.getNextNode() != null; i++) {
			current = current.getNextNode(); // Grab the index value and store it
		}
		
		// Reference tempNodes next node to currents next node
		tempNode.setNextNode(current.getNextNode());
		// Refernece currents next node to temp nodes next node
		current.setNextNode(tempNode.getNextNode());
		// Increment the size up by one
		size++;
		
	}
	
	public ComputerPart get(int index) {
		// Returns the element at the specified index
		
		// Do a check and see if the index is 1 or higher
		if (index <= 0) {
			throw new NoSuchPartException("The index cannot be less than one");
		}
		
		PartsNode<ComputerPart> current = head.getNextNode();
		for (int i = 0; i < index; i++) {
			if (current.getNextNode() == null) {
				throw new NoSuchPartException("That part is null");
			}
			
			current = current.getNextNode();
		} 
		
		return current.getComputerPart();
	}
	
	public void remove(int index) {
		// Remove the element at the specified index value
		
		// Do a check and see if the index is not out of bounds or negative
		if (index < 1 || index > size) {
			throw new NoSuchPartException("The index is out of bounds or negative");
		}
		
		PartsNode<ComputerPart> current = head;
		
		for (int i = 0; i < index; i++) {
			if (current.getNextNode() == null) {
				System.out.println("The node was null");
			}
			
			current = current.getNextNode();
		}
		// Set the next node 
		current.setNextNode(current.getNextNode().getNextNode());
		// Decrement the size by one
		size--;
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
	
	public ComputerPart searchAndRemove(String name) {
		
		if (size == 0) {
			throw new NoSuchPartException("The list is empty");
		}
		
		PartsNode<ComputerPart> currentNode = head;
		PartsNode<ComputerPart> before;
		
		String descriptionFromNode = currentNode.getComputerPart().getName().toLowerCase();
		String lowerCaseParameter = name.toLowerCase();
		
		ComputerPart partToReturn = null;
		
		boolean isItThere = false;
		
		// Catch and see if there is an item with that name in the system
		for (int i = 0; i < size; i++) {
			String description = currentNode.getComputerPart().description.toLowerCase();
			isItThere = description.contentEquals(lowerCaseParameter);
			
			description = currentNode.getNextNode().getComputerPart().description.toLowerCase();
		}
		
//		if (!isItThere) {
//			throw new NoSuchPartException("This part does not exist");
//		}
		
		// If it is the first element 
		if (descriptionFromNode.equals(lowerCaseParameter)) {
			// We already have the item grab it remove it and return it
			ComputerPart data = head.getComputerPart(); // Rely here on garbage collection
			head = head.getNextNode();
			return data;
		} else {
			// Else search through the list and find the item then remove it from the list and return it 
			
			// Go through list
			for (int i = 0; i < size; i++) {
				String current = currentNode.getComputerPart().getName().toLowerCase();
				
				if (current.equals(lowerCaseParameter)) {
					partToReturn = currentNode.getComputerPart();
					
					currentNode.setNextNode(currentNode.getNextNode().getNextNode()); // Rearrange reference in memory
					size--; // Decrease size of list by one part
					
					return partToReturn;
				}
			}
			
		}
		
		return partToReturn;
		
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
		
		/**** TEST PASS ****/
		
		// Delete and item from the linked list at a current position
		list.remove(2);
		System.out.println(list.toString());
		
		/**** TEST PASS ****/
		
		// Get the Average Price
		
		System.out.println(list.averagePrice());
		
		/**** TEST PASS ****/
		
		// Search and remove a part
		System.out.println(list.toString());
		list.searchAndRemove("TapeDrive");
		System.out.println(list.toString());
		
		/**** NO CHANGE ****/
		
		// Insert an item
		
				TapeDrive tapeDrive2 = new TapeDrive(200, 3000, 5);
				tapeDrive2.setCost(5.00);
				
				list.insert(tapeDrive2, 4);
				System.out.println(list.toString());
				
		/**** FAILS ****/
		
	}
	
}
