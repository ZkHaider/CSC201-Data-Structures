package ComputerParts;

/*
 * Name: Haider Khan
 * Date: 1/26/15
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 * Class: Data Structures
 * Description: Case class with cost and description that tells you the
 * 				cost of a specific part
 * 
 */

public class Case extends ComputerPart {

	public Case(double cost) {
		super();
		this.name = "Case";
		this.cost = cost;
		this.description = "The cost for this case is " + cost;
	}
	
	public String toString() {
		return description;
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}

}
