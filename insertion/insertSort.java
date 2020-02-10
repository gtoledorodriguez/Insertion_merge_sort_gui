/**
 * 
 */
package insertion;

/**
 * @author grace
 *
 */
public class insertSort extends insertElement{
	static void insertionSort()
	// Sorts the values array using the insertion sort algorithm.
	{
	 for (int count = 1; count < SIZE; count++)
		 insertElement.insertElement(0, count);
	}
	public static void main(String []args) {
		insertSort.insertionSort();
		for (int i = 0; i < SIZE; i++) 
			System.out.println(values[i]);
	}
}
