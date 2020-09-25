/**
 * 
 */
package exceptions;

/**
 * @author avanbala
 *
 */
public class NoUpperAlphaException extends Exception{

	/**
	 * Constructor with no argument, displayed when
	 * user enters in password with no upper case char
	 */
	public NoUpperAlphaException() {}
	
	/**
	 * Constructor for NoUpperAlphaException
	 * @param message 
	 * Password does not contain a upper case character.
	 */
	public NoUpperAlphaException(String message) {
		super(message);
	}
}
