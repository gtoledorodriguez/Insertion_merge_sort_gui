package insertion;
import java.util.Random;
public class Session implements Values {
	private String message;
	private String getInsSorted;
	public Session() {
		message = "Welcome!";
		getInsSorted = "";
	}
	public String getMessage() {
		return message;
	}
	public int[] randomNumbers() {
		Random rand = new Random();
	    for(int i = 0; i < SIZE; i++){
	    	values[i] = rand.nextInt(SIZE);
	    }
	    return values;
	}
	public boolean insertion(boolean inProgress) {
		insertSort.insertionSort();
		return inProgress;
	}
}
