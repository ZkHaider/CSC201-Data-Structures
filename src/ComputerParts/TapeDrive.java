package ComputerParts;

/*
 * Name: Haider Khan
 * Date: 1-28-15
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 * Description: "A Tape drive class that has a capacity for memory,
 * 				a latency value, current position and the description"
 */

public class TapeDrive {
	
	private int capacity; 
	private double latency;
	private int position;
	private String description;
	
	public TapeDrive(int capacity, double latency, int position) {
		this.capacity = capacity;
		this.latency = latency;
		this.position = position;
		description = "The capacity of the tape drive is "  + capacity +
					  ", the latency is "  + latency + " and the position is"
					  + position;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getLatency() {
		return latency;
	}

	public void setLatency(double latency) {
		this.latency = latency;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}
