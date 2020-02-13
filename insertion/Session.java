package insertion;
import java.util.Random;
import java.util.ArrayList;
import insertion.MergeSort;
/**
 * 
 * @author grace
 * @author gladys
 *
 */
public class Session implements Values {
	private String message;
	private String numbers;
	public Session() {
		message = "Welcome! Click Insert or Merge to sort the above numbers.";
		numbers = "";
	}
	public String getMessage() {
		return message;
	}
	public String getNumbers() {
		message = "Welcome! Click Insert or Merge to sort the above numbers.";
		numbers = "";
		randomNumbers();
		for (int i = 0; i < SIZE; i++) {
			numbers += String.valueOf(values[i]);
		}
		return numbers;
	}
	public int[] randomNumbers() {
		Random rand = new Random();
	    for(int i = 0; i < SIZE; i++){
	    	values[i] = rand.nextInt(SIZE);
	    }
	    return values;
	}
	public ArrayList<int[]> insertion() {
		ArrayList<int[]> sortedSeq = InsertionSort.insertionSort();
		message = "Click to reset button to start again.";
		return sortedSeq;
	}
	public ArrayList merge() {
		ArrayList msAL2 = MergeSort.guiSort();
		
	    //System.out.println("\nArray List");
	    //for(int i = 0; i<msAL2.size();i++) {
	    	//System.out.println(msAL2.get(i));
	    //}
		message = "Click the reset button to start again.";
	    return msAL2;
	}
}
