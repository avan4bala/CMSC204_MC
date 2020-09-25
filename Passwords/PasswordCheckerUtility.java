/**
 * 
 */
package asgn1;
import java.util.ArrayList;

import java.util.regex.Pattern;

import exceptions.InvalidSequenceException;
import exceptions.LengthException;
import exceptions.NoDigitException;
import exceptions.NoLowerAlphaException;
import exceptions.NoSpecialCharacterException;
import exceptions.NoUpperAlphaException;
import exceptions.UnmatchedException;

import java.util.regex.Matcher;

/**
 * @author avanbala
 * PasswordCheckerUtility checks the conditions of the passwords entered 
 * by the user to meet standards of a valid password
 */
public class PasswordCheckerUtility {

    public PasswordCheckerUtility() {
    }

    /**
   	 * A method that compares passwords entered
   	 * @param password entered
   	 * @throws UnmatchedException
   	 */
   
    static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (password.compareTo(passwordConfirm) != 0)
            throw new UnmatchedException("Passwords do not match");
    }

    /**
   	 * A method that compares passwords entered
   	 * @param password entered
   	 * @return unmatching password
   	 */
    
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        if (password.compareTo(passwordConfirm) != 0)
            return false;
        return true;
    }
    
    /**
   	 * A method that checks if password has between 6 to 9 char
   	 * @param password entered
   	 * @return true or false
   	 */

    public static boolean hasBetweenSixAndNineChars(String password) {

        if (password.length() >= 6 && password.length() <= 9)
            return true;

        return false;

    }
    
    /**
   	 * A method that checks if password has a number
   	 * @param password entered
   	 * @return true 
   	 * @throws NoDigitException
   	 */
    
    public static boolean hasDigit(String password) throws NoDigitException {
        for (int x = 0; x < password.length(); x++) {
            Character letter = password.charAt(x);
            if (Character.isDigit(letter)) {
                return true;
            }
        }
        throw new NoDigitException("The password must contain at least one digit");
    }

    /**
   	 * A method that checks if password has a lower case char
   	 * @param password entered
   	 * @return true 
   	 * @throws NoLowerAlphaException
   	 */
    
    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        for (int x = 0; x < password.length(); x++) {
            Character letter = password.charAt(x);
            if (Character.isLowerCase(letter)) {
                return true;
            }
        }
        throw new NoLowerAlphaException("The password must contain at least one lower case alphabetic character");
    }

    /**
   	 * A method that checks if password has repeating char
   	 * @param password entered
   	 * @return true 
   	 * @throws InvalidSequenceException
   	 */
    
    public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
        for (int x = 0; x < (password.length()) - 2; x++) {
            Character character1 = password.charAt(x);
            Character character2 = password.charAt(x + 1);
            Character character3 = password.charAt(x + 2);
            if (character1 == character2 && character2 == character3)
                throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence");
        }
        return true;
    }

    /**
   	 * A method that checks if password has a special char
   	 * @param password entered
   	 * @return true 
   	 * @throws NoSpecialCharacterException
   	 */
    
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]"); //Read JavaDoc on Special Characters, pattern obtained
        Matcher matcher = pattern.matcher(password);
        boolean hasSpecialChar = matcher.find();
        if (hasSpecialChar == false) {
            throw new NoSpecialCharacterException("The password must contain at least one special character");
        }
        return true;
    }
    
    /**
   	 * A method that checks if password has an upper case char
   	 * @param password entered
   	 * @return true
   	 * @throws NoUpperAlphaException
   	 */
    
    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        for (int x = 0; x < password.length(); x++) {
            Character letter = password.charAt(x);
            if (Character.isUpperCase(letter)) {
                return true;
            }
        }
        throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
    }
    
    /**
   	 * A method that checks if password is at least 6 char
   	 * @param password
   	 * @return true 
   	 * @throws LengthException
   	 */
    
    public static boolean isValidLength(String password) throws LengthException {
        if (password.length() < 6) {
            throw new LengthException("The password must be at least 6 characters long");
        }
        return true;
    }

    //Psuedo Code for method provided on design
    
    /**
	 * Method that accepts password and checks if it meets requirements
	 * @param password entered
	 * @return true or false
	 * @throws LengthException
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 */
    
    public static boolean isValidPassword(String password) throws LengthException,
            NoDigitException,
            NoUpperAlphaException,
            NoLowerAlphaException,
            NoSpecialCharacterException,
            InvalidSequenceException {

        if (!(isValidLength(password))) {
            throw new LengthException("The password must be at least 6 characters long"); //check length
        } else if (!(hasUpperAlpha(password))) {
            throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character"); //check upper case
        } else if (!(hasLowerAlpha(password))) {
            throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character"); //check lower case
        } else if (!(hasDigit(password))) {
            throw new NoDigitException("The password must contain at least one digit"); //check digit
        } else if (!(hasSpecialChar(password))) {
            throw new NoSpecialCharacterException("The password must contain at least one special character"); //check special
        } else if (!(hasSameCharInSequence(password))) {
            throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence"); //check sequence
        }

        return true;
    }

    /**
	 * A method that determines whether or not a password is weak, returns inherited method
	 * @param password entered
	 * @return true or false
	 */
    
    public static boolean isWeakPassword(String password) {
        return hasBetweenSixAndNineChars(password);
    }

    /**
	 * A method that accepts a list of passwords and returns invalid passwords
	 * @param passwords entered
	 * @return invalidPasswords
	 */
   
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

        ArrayList<String> invalidPasswords = new ArrayList<>();

        for (String password : passwords) {
            try {
                isValidPassword(password);
            } catch (Exception e) {
                invalidPasswords.add(password + " -> " + e.getMessage());
            }
        }
        return invalidPasswords;
    }
}
