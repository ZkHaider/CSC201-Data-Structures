import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Name: Haider Khna
 * Date: 1-17-15
 * "I pledge that I have acted honorably" - Haider Khan
 * CSC 202 - Data Structures 
 * 
 * Purpose: To create an example object which has a name and a count
 * 			an output method which outputs the name in the system print
 * 			window and getter and setter methods along with a comparable
 * 			method.
 */


public class Example implements Comparable {

	// Non-static variables for the Example class
	private int count; 
	private String name; 
	
	// Constructor
	public Example(int count, String name) {
		setCount(count);
		setName(name);
	}
	
	public void output() {
		for (int i = 0; i < count; i++) {
			System.out.println(name);
		}
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		if (count >= 0) {
			this.count = count;
		} else {
			System.out.println("Sorry the count cannot be less than 0");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Object anotherExample) {
		if (!(anotherExample instanceof Example)) {
			throw new ClassCastException("An Example object expected");
		}
		
		int anotherExampleCount = ((Example) anotherExample).getCount();
		return this.count - anotherExampleCount;
	}
	
	public static void main(String[] args) {
		
		String[] names = {"Joe", "Larry", "Kevin", "Haider", "Oscar", "Brian", "James", 
						  "Sally", "Katie", "Tim" };
		
		Example[] examples = new Example[names.length];
		
		for (int i = 0; i < names.length; i++) {
			Random random = new Random();
			// Add 1 to make it inclusive, because normally exclusive to the top value
			int randomNo = random.nextInt((10 - 1) + 1) + 1;
			
			Example example = new Example(randomNo, names[i]);
			examples[i] = example;
			examples[i].output();
		}
		
	}
	
}


