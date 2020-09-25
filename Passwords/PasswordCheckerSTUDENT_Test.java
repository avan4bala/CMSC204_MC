
package asgn1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import exceptions.InvalidSequenceException;
import exceptions.LengthException;
import exceptions.NoDigitException;
import exceptions.NoLowerAlphaException;
import exceptions.NoSpecialCharacterException;
import exceptions.NoUpperAlphaException;
import exceptions.UnmatchedException;

/**
 * @author avanbala
 *
 */

class PasswordCheckerSTUDENT_Test {
	
	/**
	 * Below is a list of sample test passwords for each criteria that the Junit tests will check
	 */

	ArrayList<String> invalidPasswordsArray;
	ArrayList<String> validPasswordsArray;
	String password = "Hello";
	String passwordConfirm = "hello";
	String allCaps = "HELLO";
	String withDigit = "Hello8484";
	String withSpecial = "Hello!";
	String withDouble = "GoooodBye!?!";
	String between6And9Chars = "AvanBala";
	String longPassword = "ABalasubramaniam";
	
	
	/**
	 * @throws Exception 
	 * All passwords are examples of invalid passwords, criteria that they don't meet is listed as String
	 */

	@BeforeEach
	void setUp() throws Exception {
		String[] containsInvalidPwd = {"334455BB", "Im2cool4U", "bala7yZZZ", "5ever", "batman092", "5yuckMonday", 
				"september26", "ApplestoApples", "aa11b", "businessMetric", "abcdEfg", 
				"abcdEfg6"};
		
		invalidPasswordsArray = new ArrayList<String>();
		invalidPasswordsArray.addAll(Arrays.asList(containsInvalidPwd));		
		
		String[] allValidPasswords = {"a3A#b3Bc3Cd3D", "Hello@123", "4heB#rex7", "5everHe!", "abcdEfg2%"};
		
		validPasswordsArray = new ArrayList<String>();
		validPasswordsArray.addAll(Arrays.asList(allValidPasswords));		
	}
	
	/**
	 * @throws Exception
	 * Return null after tests have been conducted
	 */

	@AfterEach
	void tearDown() throws Exception {
		invalidPasswordsArray = null;
		validPasswordsArray= null;
	}

	/**
	 * Compares passwords entered to see if they match
	 */
	
	@Test
	void testComparePasswords() {
		Throwable exception = assertThrows(UnmatchedException.class, new Executable() {			
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.comparePasswords(password, passwordConfirm);				
			}
		});
		
		assertEquals("Passwords do not match", exception.getMessage());
	}
	
	/**
	 * Returns true or false (message) if passwords don't match
	 */
	
	@Test 
	void testComparePasswordsWithReturn() {
		assertFalse(PasswordCheckerUtility.comparePasswordsWithReturn(password, passwordConfirm));
		assertTrue(PasswordCheckerUtility.comparePasswordsWithReturn(password, password));
	}	
	
	
	@Test
	void testValidLengthValid() {
		try {
			assertTrue(PasswordCheckerUtility.isValidLength("Kaleidescope"));
		} catch (LengthException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Test to see if password is at least 6 characters
	 */
	
	@Test
	void testInValidLength() {
		Throwable exception = Assertions.assertThrows(LengthException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidLength(password);
			}			
		});
		assertEquals("The password must be at least 6 characters long", exception.getMessage());
	}
	
	
	/**
	 * Test to see if password has an upper case
	 */
	
	@Test
	void testHasUpperAlphaValid() {
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("Kronos"));
		} catch (NoUpperAlphaException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws Exception if there is no upper case
	 */
	
	@Test
	void testDoesNotHaveUpperAlpha() {
		Throwable exception = assertThrows(NoUpperAlphaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasUpperAlpha(passwordConfirm);
			}			
		});
		assertEquals("The password must contain at least one uppercase alphabetic character", exception.getMessage());		
	}
	
	/**
	 * Test to see if password has a lower case
	 */
	
	@Test
	public void testHasLowerAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(password));
		} catch (NoLowerAlphaException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * @throws Exception if there is no lower case
	 */
	
	@Test
	public void testDoesNotHaveLowerAlpha() {
		Throwable exception = assertThrows(NoLowerAlphaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasLowerAlpha(allCaps);
			}			
		});
		assertEquals("The password must contain at least one lower case alphabetic character", exception.getMessage());
		
	}
	
	
	/**
	 * Test to see if password has a digit
	 */
	
	@Test
	public void testHasDigit() {
		try {
			assertTrue(PasswordCheckerUtility.hasDigit(withDigit));
		} catch (NoDigitException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * @throws Exception if there is no digit
	 */
	
	@Test
	public void testDoesNotHaveDigit() {
		Throwable exception = assertThrows(NoDigitException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasDigit(password);
			}			
		});
		assertEquals("The password must contain at least one digit", exception.getMessage());		
	}
	
	/**
	 * Test to see if password has a special character (from list)
	 */
	
	@Test
	public void testHasSpecialChar() {
		try {
			assertTrue(PasswordCheckerUtility.hasSpecialChar(withSpecial));
		} catch (NoSpecialCharacterException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * @throws Exception if there is no special character
	 */
	
	@Test
	public void testDoesNotHaveSpecialChar() {
		Throwable exception = assertThrows(NoSpecialCharacterException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasSpecialChar(password);
			}			
		});
		assertEquals("The password must contain at least one special character", exception.getMessage());		
	}
	
	/**
	 * Test to see if password has the same character repeating
	 */
	
	@Test
	public void testHasSameCharInSequence() {
		Throwable exception = assertThrows(InvalidSequenceException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasSameCharInSequence("AAAbb@123");
			}			
		});
		assertEquals("The password cannot contain more than two of the same character in sequence", exception.getMessage());	
	}
	
	/**
	 * @throws Exception if there is a repeating char
	 */
	
	@Test
	public void testDoesNotHaveSameCharInSequence() {
		try {
			assertTrue(PasswordCheckerUtility.hasSpecialChar(withDouble));
		} catch (NoSpecialCharacterException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Test to see if password has between 6 and 9 characters
	 */
	
	@Test
	public void testHasBetweenSixAndNineChars() {
		assertTrue(PasswordCheckerUtility.hasBetweenSixAndNineChars(between6And9Chars));	
		assertTrue(PasswordCheckerUtility.hasBetweenSixAndNineChars(withSpecial));	
		assertFalse(PasswordCheckerUtility.hasBetweenSixAndNineChars(longPassword));	
	}
	
	/**
	 * List of invalid passwords and their failures
	 */
	
	@Test
	public void testGetInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(invalidPasswordsArray);
		assertEquals(results.size(), 12);
		assertEquals(results.get(0), "334455BB -> The password must contain at least one lower case alphabetic character");
		assertEquals(results.get(1), "Im2cool4U -> The password must contain at least one special character");
		assertEquals(results.get(2), "bala7yZZZ -> The password must contain at least one special character");
		assertEquals(results.get(3), "5ever -> The password must be at least 6 characters long");
		assertEquals(results.get(4), "batman092 -> The password must contain at least one uppercase alphabetic character"); 
		assertEquals(results.get(5), "5yuckMonday -> The password must contain at least one special character");
		assertEquals(results.get(6), "september26 -> The password must contain at least one uppercase alphabetic character");
		assertEquals(results.get(7), "ApplestoApples -> The password must contain at least one digit");
		assertEquals(results.get(8), "aa11b -> The password must be at least 6 characters long");
		assertEquals(results.get(9), "businessMetric -> The password must contain at least one digit");
		assertEquals(results.get(10), "abcdEfg -> The password must contain at least one digit");
		assertEquals(results.get(11), "abcdEfg6 -> The password must contain at least one special character");
	}
	
	@Test
	public void testGetValidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(validPasswordsArray);
		assertTrue(results.isEmpty());
	}
	

}
