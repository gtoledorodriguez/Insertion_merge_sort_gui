package insertion;
import java.util.Random;
import java.util.ArrayList;
import insertion.MergeSort;
public class Session implements Values {
	private String message;
	private String numbers;
	private String getInsSorted;
	public Session() {
		message = "Welcome!";
		numbers = "";
		getInsSorted = "";
	}
	public String getMessage() {
		return message;
	}
	public String getNumbers() {
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
	public ArrayList insertion() {
		ArrayList sortedSeq = insertSort.insertionSort();
		return sortedSeq;
	}
	public ArrayList merge() {
		ArrayList msAL2 = MergeSort.guiSort();
		
	    System.out.println("\nArray List");
	    for(int i = 0; i<msAL2.size();i++) {
	    	System.out.println(msAL2.get(i));
	    }
	    
	    return msAL2;
	}
}
