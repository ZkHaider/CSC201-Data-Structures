package ComputerParts;

public class GraphicsCard extends ComputerPart {
	
	public static final String NAME = "GraphicsCard";
	
	public GraphicsCard(int capacity, double latency) {
		this.capacity = capacity;
		this.latency = latency;
		this.description = "This is a GraphicsCard Object, it's capacity is " +
					capacity + ", its latency is " + latency;
		
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
