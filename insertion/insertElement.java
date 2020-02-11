package insertion;

public class insertElement implements Values{
	static int[] insertElement(int startIndex, int endIndex)
	// Upon completion, values[0]..values[endIndex] are sorted.
	{
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
	return values;
	}
	static void swap(int first, int second) {
		int temp = values[first];
		values[first] = values[second];
		values[second] = temp;
	}
}
