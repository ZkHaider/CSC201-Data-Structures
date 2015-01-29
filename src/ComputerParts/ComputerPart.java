package ComputerParts;

public abstract class ComputerPart {
	
	protected int capacity;
	protected double cost;
	protected double latency;
	protected String description;
	private boolean isComputerPart;
	
	
	public boolean isComputerPart(Object object) {
		
		if (object.equals(getClass())) {
			isComputerPart = true;
			return isComputerPart;
		} else {
			return false;
		}
		
	}

}
