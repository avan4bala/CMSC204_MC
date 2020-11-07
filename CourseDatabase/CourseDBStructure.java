/**
 * 
 */
package asgn4;
import java.io.IOException;
import java.util.*;
/**
 * @author avanbala
 *
 */

public class CourseDBStructure implements CourseDBStructureInterface
{

	LinkedList<CourseDBElement>[] hashTable;
	int tablesize ;
	int size;

	@SuppressWarnings("unchecked")
	public CourseDBStructure(int size1)
	{
		this.size = 0;
		this.tablesize = size1;
		hashTable=new LinkedList[size1];
	}

	@SuppressWarnings("unchecked")
	public CourseDBStructure(String s, int size1)
	{
		this.size = 0;
		this.tablesize = size1;
		hashTable=new LinkedList[size1];
	}



	@Override
	public void add(CourseDBElement element)
	{
		int hash =element.hashCode()%getTableSize();

		if(hashTable[hash]!=null){
		hashTable[hash].add(element);}
		else
		{
			hashTable[hash]=new LinkedList<CourseDBElement>();
			hashTable[hash].add(element);
		}
	}

	@Override
	public CourseDBElement get(int crn) throws IOException
	{
		System.out.println("Tbl: " + tablesize);
		for(int j=0;j<getTableSize();j++)
		{
			if(hashTable[j]==null)
				continue;

			LinkedList<CourseDBElement> ll=hashTable[j];
			for(int i=0;i<ll.size();i++)
			{
				if(ll.get(i).CRN==crn)
				{
					return ll.get(i);
				}
			}
		}
		throw new IOException();
	}



	@Override
	public int getTableSize()
	{
		return tablesize;
	}

	public ArrayList<String> showAll()
	{
		@SuppressWarnings("unused")
		CourseDBElement cde = new CourseDBElement();

		ArrayList<String> array = new ArrayList<String>();
		for(int i = 0; i < getTableSize(); i++)
		{
			if(hashTable[i] != null)
			{
				LinkedList<CourseDBElement> ll=hashTable[i];
				for(CourseDBElement next : ll)
				{
					String cdeString = "\n"+next;
					array.add(cdeString);
				}
			}
		}
		Collections.sort(array);
		return array;
	}

}
