package ComputerParts;

public class Case {
	
	private double cost;
	private String description;

	public Case(double cost) {
		this.cost = cost;
		description = "The cost for this case is " + cost;
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
	

}
