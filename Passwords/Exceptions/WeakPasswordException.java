/**
 * 
 */
package exceptions;

/**
 * @author avanbala
 *
 */
public class WeakPasswordException extends Exception{

	/**
	 * Constructor with no argument, displayed when
	 * user enters in password that is between 6-9 char
	 */
	public WeakPasswordException() {}
	
	/**
	 * Constructor for WeakPasswordException
	 * @param message 
	 * Password does not contain more than 9 characters.
	 */
	public WeakPasswordException(String message) {
		super(message);
	}
}
