package ComputerParts;

public class PartsNode {
	
	private ComputerPart computerPart;
	private PartsNode next;
	
	public PartsNode(ComputerPart computerPart, PartsNode next) {
		this.computerPart = computerPart;
		this.next = next;
	}

}
