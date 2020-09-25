/**
 * 
 */
package exceptions;

/**
 * @author avanbala
 *
 */
public class NoLowerAlphaException extends Exception{

	/**
	 * Constructor with no argument, displayed when
	 * user enters in password with no lower case char
	 */
	public NoLowerAlphaException() {}
	
	/**
	 * Constructor for NoLowerAlphaException
	 * @param message 
	 * Password does not contain a lower case character.
	 */
	public NoLowerAlphaException(String message) {
		super(message);
	}
}
