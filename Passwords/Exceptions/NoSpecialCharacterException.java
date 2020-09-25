/**
 * 
 */
package exceptions;

/**
 * @author avanbala
 *
 */
public class NoSpecialCharacterException extends Exception{

	/**
	 * Constructor with no argument, displayed when
	 * user enters in password with no special char
	 */
	public NoSpecialCharacterException() {}
	
	/**
	 * Constructor for NoSpecialCharacterException
	 * @param message 
	 * Password does not contain a special character.
	 */
	public NoSpecialCharacterException(String message) {
		super(message);
	}
}
