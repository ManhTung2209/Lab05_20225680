package hust.soict.dsai.aims.exception;

public class PlayerException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PlayerException() {
        super();
    }
    public PlayerException(String message) {
        super(message);
    }
    public PlayerException(String message, Throwable cause) {
        super(message, cause);
    }
    public PlayerException(Throwable cause) {
        super(cause);
    }
}
