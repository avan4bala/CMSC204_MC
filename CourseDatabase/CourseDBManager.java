/**
 * 
 */
package asgn4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author avanbala
 *
 */


public class CourseDBManager implements CourseDBManagerInterface
{
	CourseDBStructure cds = new CourseDBStructure(20);
	CourseDBElement cde = new CourseDBElement();

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor)
	{
		CourseDBElement cde = new CourseDBElement(id, crn, credits, roomNum, instructor);
		cds.add(cde);
	}

	@Override
	public CourseDBElement get(int crn)
	{
		try {
			return cds.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException
	{
		String FILE_NAME = "C:\\Users\\ritika\\Desktop\\Assignment\\Fall2021\\Computer Science 204\\Week 7\\Assignment 4\\courses.txt";
		Scanner scnr = new Scanner(new FileInputStream(FILE_NAME));
		while (scnr.hasNextLine())
		{
			System.out.println(scnr.nextLine());
		}
		scnr.close();
	}

	@Override
	public ArrayList<String> showAll()
	{
		return cds.showAll();
	}




}
