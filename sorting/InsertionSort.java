package sorting;
import java.util.ArrayList;
/**
 * @author grace
 *
 */
public class InsertionSort extends insertElement{
	/**
	 * Sorts the values array using the insertion sort algorithm.
	 * @return an Integer array ArrayList, where each array is a different step in the insertion sort algorithm
	 */
	static ArrayList<int[]> insertionSort() {
		// sortedSeq is the ArrayList that will be populated with sorted integer arrays
		ArrayList<int[]> sortedSeq = new ArrayList<int[]>();
		// insert will keep track of each step as the array is sorted
		int[] insert = new int[SIZE];
		// clone is a copy of insert that is added to the ArrayList to show the steps of the insertion sort algorithm
		int[] clone = new int[SIZE];
		// This for loop runs through the insertElement method for each step, and adds the sorted array to sortedSeq
		for (int count = 1; count < SIZE; count++) {
			// insert is set to the next step in sorting values
			insert = insertElement.insertElement(0, count);
			// clone clones insert
			clone = insert.clone();
			// clone is added to sortedSeq
			sortedSeq.add(clone);
		}	 	
		// Finally, sortedSeq is returned
		return sortedSeq;
	}
}
