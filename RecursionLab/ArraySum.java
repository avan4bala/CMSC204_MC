
package Lab;

/**
 * @author avanbala
 *
 */

/**
 * @param name of the array 
 * @param x index last into array
 * @return sum of array elements
 */

public class ArraySum {
	public int sumOfArray (Integer[] a, int x) {
		if (x < 0) {
		      return 0;
		    }
		    return sumOfArray(a, x - 1) + a[x];
		  }
}
