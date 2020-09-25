package asgn1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.LengthException;
import exceptions.NoDigitException;
import exceptions.NoSpecialCharacterException;


/**
 * Test the methods of PasswordChecker
 * @author Professor Kartchner
 *
 */
public class PasswordChecker_GFA_Test {
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}
	
	@Test
	public void testisValidLengthTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidLength("abc12"));
		}
		catch(LengthException e)
		{
			assertTrue(e.getMessage().equalsIgnoreCase("The password must be at least 6 characters long"));
		}
	}	
	
	@Test
	public void testIsValidPasswordSuccess()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("strongPWD1"));
		}
		catch (NoSpecialCharacterException e) {
			assertTrue(e.getMessage().equalsIgnoreCase("The password must contain at least one special character"));
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException", false);
		} 
	}
	
	
	/**
	 * Test if the password is less than 8 characters long.
	 * This test Will NOT throw a LengthException for second case.	 
	 * Because the pwd is 6 chars long, however does not meet other req and we are NOT catching them in this test case,
	 * Therefore it will execute  assertTrue("Threw some incorrect exception",false);
	 * this line will fail, since it Asserts that you are getting the "Threw some incorrect exception" and if not it will fail
	 * this should fail because you should be getting your exception's' custom message and not "Threw some incorrect exception"
	 */	
	
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("abcABs"));
		}
		catch(NoDigitException e)
		{
			assertTrue(e.getMessage().equalsIgnoreCase("The password must contain at least one digit"));
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException", false);
		} 
	}
	
	
}
