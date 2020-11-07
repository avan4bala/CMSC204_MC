/**
 * 
 */
package asgn4;

/**
 * @author avanbala
 *
 */


public class CourseDBElement implements Comparable
{
	int CRN;
	int numCredits;
	String roomNum;
	String instructorName;
	String hashcod;
	String courseID;
	public String getCourseID() {
		return courseID;
	}

	/**
	 * @param courseID
	 */
	
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	/**
	 * @return CRN
	 */
	
	public int getCRN() {
		return CRN;
	}

	/**
	 * @param crn
	 */
	
	public void setCRN(int crn) {
		this.CRN = crn;
	}
	
	/**
	 * @return numCredits
	 */

	public int getNumCredits() {
		return numCredits;
	}

	/**
	 * @param numCredits
	 */
	
	public void setNumCredits(int numCredits) {
		this.numCredits = numCredits;
	}

	/**
	 * @return roomNum
	 */
	
	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	/**
	 * 
	 */
	
	public CourseDBElement()
	{
		courseID = null;
		CRN = 0;
		numCredits = 0;
		roomNum = null;
		instructorName = null;
		this.hashcod=hashcode();
	}

	public CourseDBElement(String courseID,int CRN,int numCredits,String roomNum,String instructorName)
	{
		this.courseID = courseID;
		this.CRN = CRN;
		this.numCredits = numCredits;
		this.roomNum = roomNum;
		this.instructorName = instructorName;
		this.hashcod=hashcode();
	}

	//"\nCourse:CMSC203 CRN:30503 Credits:4 Instructor:Jill B. Who-Dunit Room:SC450"
	public String toString()
	{
		String s = ("Course:"+courseID
					+" CRN:"+CRN
					+" Credits:"+numCredits
					+" Instructor:"+instructorName
					+" Room:"+roomNum);
		return s;
	}



	public String hashcode()
	{
		return ""+((""+CRN).hashCode());
	}

	@Override
	public int compareTo(CourseDBElement element)
	{
		if(CRN < element.CRN)
			return -1;
		else if(CRN > element.CRN)
			return 1;
		else
			return 0;
	}

}
