/**
 * 
 */
package exceptions;

/**
 * @author avanbala
 *
 */
public class UnmatchedException extends Exception{

	/**
	 * Constructor with no argument, displayed when
	 * user enters in passwords that do not match
	 */
	public UnmatchedException() {}
	
	/**
	 * Constructor for UnmatchedException
	 * @param message 
	 * Passwords do not match.
	 */
	public UnmatchedException(String message) {
		super(message);
	}
}
