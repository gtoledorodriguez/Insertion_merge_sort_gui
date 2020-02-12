/**
 * 
 */
package insertion;
import java.util.ArrayList;
/**
 * @author grace
 *
 */
public class InsertionSort extends insertElement{
	static ArrayList<int[]> insertionSort()
	// Sorts the values array using the insertion sort algorithm.
	{
	ArrayList<int[]> sortedSeq = new ArrayList<int[]>();
	int[] n = new int[SIZE];
	 for (int count = 1; count < SIZE; count++) {
		 n = insertElement.insertElement(0, count);
	 	sortedSeq.add(n);
	 }
	 return sortedSeq;
	}
	
}
