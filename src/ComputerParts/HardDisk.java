package ComputerParts;

public class HardDisk extends ComputerPart {
	
	public HardDisk(int capacity, double latency) {
		super();
		this.capacity = capacity;
		this.latency = latency;
		this.description = "This is a HardDisk Object, it's capacity is " +
					capacity + ", its latency is " + latency + " and its description is " +
					description;
		
	}
	
	public String toString() {
		return description;	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}
