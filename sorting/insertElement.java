package sorting;
/**
 * 
 * @author grace
 * 
 */
public class insertElement implements Values{
	/**
	 * Upon completion, values[0]..values[endIndex] are sorted.
	 * @param startIndex
	 * @param endIndex
	 * @return values, the sorted array
	 */
	static int[] insertElement(int startIndex, int endIndex) {
		// finished keeps track of whether or not the array is done being sorted.
		boolean finished = false;
		// current is the current index that the algorithm is sorting from. Here it is set to the ending index.
		int current = endIndex;
		// moreToSearch keeps track of whether the algorithm should keep sorting or not.
		boolean moreToSearch = true;
		// This while loop iterates until it is finished sorting
		while (moreToSearch && !finished) {
			// If the current value is less than the last value, 
			if (values[current] < values[current - 1]) {
				// Then they are swapped
				swap(current, current - 1);
				// And the current index is subtracted by one
				current--;
				// As long as the current index is not the starting index, it will keep searching
				moreToSearch = (current != startIndex);
			}
			// otherwise, it is finished sorting
			else
				finished = true;
		}
		// Finally, the values array is returned
		return values;
	}
	/**
	 * swap switches two values in the global array values
	 * @param first is the index of the first variable that will be switched
	 * @param second is the index of the variable that first will be switched with
	 */
	static void swap(int first, int second) {
		// temp is a temporary variable that holds the value of the first value
		int temp = values[first];
		// Then the value at the element of first is set to the value at the element of second
		values[first] = values[second];
		// Finally, the value at the element of second is set to the temporary variable
		values[second] = temp;
	}
}
