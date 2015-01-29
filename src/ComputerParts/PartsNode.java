package ComputerParts;

public class PartsNode<ComputerPart> {
	
	private ComputerPart computerPart;
	private PartsNode<ComputerPart> next;
	
	public PartsNode(ComputerPart computerPart, PartsNode<ComputerPart> next) {
		this.computerPart = computerPart;
		this.next = next;
	}
	
	public ComputerPart getComputerPart() {
		return computerPart;
	}
	
	public void setComputerPart(ComputerPart computerPart) {
		this.computerPart = computerPart;
	}
	
	public PartsNode<ComputerPart> getNextNode() {
		return next;
	}
	
	public void setNextNode(PartsNode<ComputerPart> next) {
		this.next = next;
	}

}
