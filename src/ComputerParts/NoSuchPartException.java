package ComputerParts;

public class NoSuchPartException extends IllegalArgumentException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = null;
	
	public NoSuchPartException() {
	    super();
	    System.out.println("No such part exists.");
	}
	
	public NoSuchPartException(String message) {
		super(message);
		this.message = message;
	}
	
	public NoSuchPartException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
