package ComputerParts;

public class NoSuchPartException {
	
	public NoSuchPartException() throws Exception {
	    throw new Exception("The part does not exist");
	}

}
