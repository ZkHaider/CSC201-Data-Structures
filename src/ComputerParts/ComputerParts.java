package ComputerParts;

/*
 * Name: Haider Khan
 * Original Author: Dr. Brian Patterson
 * Description: Interface for the Computer Parts Package classes
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 * Date: 1-26-15
 */

public interface ComputerParts extends Comparable<ComputerParts> {
	//Return the cost of this part in dollars
	public double getCost();
	
	//Set the cost of this part in dollars
	public void setCost(double d);
	
	//Return the name of the exactly part (note: There is no setter for this value!)
	public String getName();
	
	//Compares this to the parameter part, returning 1 if this is of higher cost 
	// than the parameter, 0 if the same, and -1 otherwise.
	public int compareTo(ComputerParts part);
}
