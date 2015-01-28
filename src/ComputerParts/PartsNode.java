package ComputerParts;

public class PartsNode {
	
	private ComputerPart computerPart;
	private PartsNode next;
	
	public PartsNode(ComputerPart computerPart, PartsNode next) {
		this.computerPart = computerPart;
		this.next = next;
	}
	
	public ComputerPart getComputerPart() {
		return computerPart;
	}
	
	public PartsNode getNextNode() {
		return next;
	}
	
	public void setComputerPart(ComputerPart computerPart) {
		this.computerPart = computerPart;
	}
	
	public void setNode(PartsNode next) {
		this.next = next;
	}

}
