/**
 * 
 */
package exceptions;

/**
 * @author avanbala
 *
 */

public class LengthException extends Exception{

	/**
	 * Constructor with no argument, displayed when
	 * user enters in a short password (less than 6 char)
	 */
	public LengthException() {}
	
	/**
	 * Constructor for LengthException
	 * @param message 
	 * Password is too short.
	 */
	public LengthException(String message) {
		super(message);
	}
}
