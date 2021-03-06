package ComputerParts;

public class FlashDrive extends ComputerPart {
	
	private int isInternalOrExternal;
	
	public FlashDrive(int capacity, double latency, int isInternalOrExternal) {
		super();
		this.name = "FlashDrive";
		this.isInternalOrExternal = isInternalOrExternal;
		this.capacity = capacity;
		this.latency = latency;
		this.description = "This is a FlashDrive Object, it's capacity is " +
					capacity + ", its latency is " + latency;
		
	}
	
	public String toString() {
		return description;	
	}
	
	public int getIsInternalOrExternal() {
		return isInternalOrExternal;
	}

	public void setIsInternalOrExternal(int isInternalOrExternal) {
		this.isInternalOrExternal = isInternalOrExternal;
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

	public String getName() {
		return name;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getCost() {
		return cost;
	}

}
