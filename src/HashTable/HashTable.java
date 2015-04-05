package HashTable;

public class HashTable<K, V> {

	private Node<K, V>[] table;
	private int size;

	// HashTable constructor
	@SuppressWarnings("unchecked")
	public HashTable(int tableSize) {
		table = new Node[nextPrime(tableSize)];
		size = 0;
	}

	// Check if empty
	public boolean isEmpty() {
		return size == 0;
	}

	// Return the size
	public int size() {
		return size;
	}

	// Put an entry into the HashTable
	public void put(K key, V value) {
		size++;
		int position = getHashCode(key);
		Node<K, V> node = new Node<K, V>(key, value);
		if (table[position] == null) {
			table[position] = node;
		} else {
			// Grab node at table[position] and replace with node
			Node<K, V> next = node.getNext();
			next = table[position];
			table[position] = node;
		}
	}
	
	public void insert(K key, V value) {
		int position = getHashCode(key);
		if (table[position] == null) {
			put(key, value);
			return;
		}
		
		Node<K, V> node = table[position];
		Node<K, V> newNode = new Node<K, V>(key, value);
		node.setNext(newNode);
	}

	// Remove the first element in the bucket
	public void remove(K key) throws Exception {
		int position = getHashCode(key);
		Node<K, V> startNode = table[position];
		if (startNode == null)
			throw new Exception("Node does not exist");
		Node<K, V> endNode = startNode;
		// See if the key matches, decrement size and return
		if (startNode.getKey() == key) {
			size--;
			table[position] = startNode.getNext();
			// Exit
			return;
		}

		while (endNode.getNext() != null && endNode.getNext().getKey() != key) {
			endNode = endNode.getNext();
		}

		if (endNode.getNext() == null) {
			System.out.println("Element node not found");
			return;
		}
		size--;

		if (endNode.getNext().getNext() == null) {
			Node<K, V> nextNode = endNode.getNext();
			nextNode = null;
			return;
		}

		Node<K, V> nextNode = endNode.getNext();
		nextNode = endNode.getNext().getNext();
		table[position] = startNode;
	}
	
	// HashCode function using simple division method
	private int getHashCode(K key) {
		int hashValue = key.hashCode();
		// Get the remainder
		hashValue %= table.length;
		// If the remainder is less than 0 add the table length to the value
		if (hashValue < 0) 
			hashValue += table.length;
		return hashValue;
	}
	
	private static int nextPrime(int n) {
		// If the tableSize remainder equals 0, we increment n by 1
		if (n % 2 == 0)
			n++;
		
		// If n is not a prime number add 2, check if prime number until it is found
		for ( ; !isPrime(n); n+= 2);
		
		return n;
	}
	
	// Check if the given number is a prime number
	private static boolean isPrime(int n ) {
		// If 2 or 3 obviously prime numbers
		if (n == 2 || n == 3)
			return true;
		// A prime number be greater than 1 and not evenly divisible with 0
		if (n == 1 || n % 2 == 0)
			return false;
		// Start at 3, if 3 * 3 is less than or equal to n increment by 2
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				// If n is evenly divisble by i return false
				return false;
		}
		return true;
	}
	
	// Get the value stored at the key parameter
	public V getValue(K key) throws Exception {
		int position = getHashCode(key);
		if (table[position] == null)
			throw new Exception("Key does not exist");
		
		// If the position is available get the value
		Node<K, V> node = table[position];
		return node.getValue();
	}
	
	public void printTable() {
		System.out.println();
		for (int i = 0; i < table.length; i++) {
			System.out.println("Bucket " + i + ": ");
			Node<K, V> start = table[i];
			while (start != null) {
				System.out.println(start.getValue().toString() + " ");
				start = start.getNext();
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		// Create a hashtable with a capacity of 100
		HashTable<Integer, String> questionHashTable = new HashTable<>(10);
		
		// Go ahead and add an entry to the table
		questionHashTable.put(1, "First Question");
		questionHashTable.put(0, "Zeroth Question");
		questionHashTable.put(2, "Second Question");
		
		// See what prints out
		//questionHashTable.printTable();
		
		// Remove a key
		questionHashTable.remove(0);
		
		// See what prints out
		//questionHashTable.printTable();
		
		questionHashTable.insert(1, "First Collision Question");
		
		// Get the size
		//System.out.println("Size : " + questionHashTable.size());
		
		//questionHashTable.printTable();
		
		// Add two more collisions
		questionHashTable.insert(0, "Zeroth Collision Question");
		questionHashTable.insert(2, "Second Collision Question");
		//questionHashTable.printTable();
		//System.out.println("Size: " + questionHashTable.size());
		
		// Remove all keys
		questionHashTable.remove(0);
		questionHashTable.remove(1);
		questionHashTable.remove(2);
		questionHashTable.printTable();
		
		questionHashTable.remove(1);
		questionHashTable.remove(2);
		questionHashTable.printTable();
	}
	
}
