package ComputerParts;

/*
 * Name: Haider Khan
 * Date: 1/26/15
 * Description: RAM class that contains cost, capacitty, latency, and a description
 * Class: Data Structures
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 */

public class RAM {
	
	private double cost;
	private int capacity;
	private double latency;
	private String stringValue;
	
	public RAM(int capacity, double latency) {
		this.capacity = capacity;
		this.latency = latency;
		stringValue = "The capacity of the RAM object is " + capacity 
					+ " , the latency is " + latency + " and the cost is " +
					cost;
	}
	
	public String toString() {
		return stringValue;
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
	
}
