package insertion;
/**
 * 
 * @author grace
 * 
 */
public class insertElement implements Values{
	/**
	 * insertElement 
	 * @param startIndex
	 * @param endIndex
	 * @return values, the sorted array
	 */
	static int[] insertElement(int startIndex, int endIndex) {
	// Upon completion, values[0]..values[endIndex] are sorted.
		boolean finished = false;
		int current = endIndex;
		boolean moreToSearch = true;
		while (moreToSearch && !finished) {
			if (values[current] < values[current - 1]) {
				swap(current, current - 1);
				current--;
				moreToSearch = (current != startIndex);
			}
			else
				finished = true;
		}
		/*
		for (int i = 0; i < SIZE; i++) {
			System.out.print(values[i]);
		}
		System.out.println();
		*/
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
