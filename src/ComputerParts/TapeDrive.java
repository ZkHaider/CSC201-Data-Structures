package ComputerParts;

/*
 * Name: Haider Khan
 * Date: 1-28-15
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 * Description: "A Tape drive class that has a capacity for memory,
 * 				a latency value, current position and the description"
 */

public class TapeDrive extends ComputerPart {
	
	public static final String NAME = "TapeDrive";
	
	private int position;
	
	public TapeDrive(int capacity, double latency, int position) {
		this.capacity = capacity;
		this.latency = latency;
		this.position = position;
		this.description = "This is a TapeDrive Object, it's capacity is " +
				capacity + ", its latency is " + latency;
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

	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String getName() {
		return NAME;
	}

}
