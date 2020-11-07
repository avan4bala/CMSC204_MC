/**
 * 
 */

package asgn4;
import java.io.*;
import java.util.*;

/**
 * @author avanbala
 *
 */


public interface CourseDBManagerInterface {

	public void add(String id, int crn, int credits, String roomNum, String instructor);

	public CourseDBElement get(int crn);

	public void readFile(File input) throws FileNotFoundException;

	public ArrayList<String> showAll();

}
