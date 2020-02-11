/**
 * 
 */
package insertion;
import java.util.ArrayList;
/**
 * @author grace
 *
 */
public class insertSort extends insertElement{
	static ArrayList<int[]> insertionSort()
	// Sorts the values array using the insertion sort algorithm.
	{
	ArrayList sortedSeq = new ArrayList();
	int[] n = new int[SIZE];
	 for (int count = 1; count < SIZE; count++) {
		 n = insertElement.insertElement(0, count);
	 	sortedSeq.add(n);
	 }
	 return sortedSeq;
	}
	
}
