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
	int[] f = new int[SIZE];
	 for (int count = 1; count < SIZE; count++) {
		n = insertElement.insertElement(0, count);
		f = n.clone();
	 	sortedSeq.add(f);
	 }	 	
	 return sortedSeq;
	}
	
}
