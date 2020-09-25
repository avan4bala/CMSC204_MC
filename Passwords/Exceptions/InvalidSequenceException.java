/**
 * 
 */
package exceptions;

/**
 * @author avanbala
 *
 */
public class InvalidSequenceException extends Exception{

	/**
	 * Constructor with no argument, displayed when
	 * user enters in password with an invalid sequence of characters
	 */
	public InvalidSequenceException() {}
	
	/**
	 * Constructor for InvalidSequenceException
	 * @param message 
	 * Password sequence is invalid.
	 */
	public InvalidSequenceException(String message) {
		super(message);
	}
}
