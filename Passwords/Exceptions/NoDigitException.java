/**
 * 
 */
package exceptions;

/**
 * @author avanbala
 *
 */

public class NoDigitException extends Exception{

	/**
	 * Constructor with no argument, displayed when
	 * user enters in password with no number
	 */
	public NoDigitException() {}
	
	/**
	 * Constructor for NoDigitException
	 * @param message 
	 * Password does not contain a numeric value.
	 */
	public NoDigitException(String message) {
		super(message);
	}
}
