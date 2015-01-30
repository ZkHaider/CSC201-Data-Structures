package ComputerParts;

/*
 * Name: Haider Khan
 * Date: 1/26/15
 * Description: RAM class that contains cost, capacitty, latency, and a description
 * Class: Data Structures
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 */

public class RAM extends ComputerPart {
	
	public static final String NAME = "RAM";
	
	public RAM(int capacity, double latency) {
		super();
		this.capacity = capacity;
		this.latency = latency;
		this.description = "This is a RAM Object, it's capacity is " +
				capacity + ", its latency is " + latency;
	}
	
	public String toString() {
		return description;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public double getLatency() {
		return latency;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void setLatency(double latency) {
		this.latency = latency;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String getName() {
		return NAME;
	}
	
}
