package insertion;
import java.util.ArrayList;
import java.util.Random;
import insertion.Session;
/**
 * 
 * @author Gladys
 * help
 */
public class MergeSort implements Values{
	static ArrayList msAL = new ArrayList(); //Will make a function that returns an arrayList so we can print it out in the GUI
	public static ArrayList guiSort() {// This method will be called in the Session.java file which will sort the same values as insertion
		MergeSort s = new MergeSort();
		s.sort(values);
		return s.getMerge();
	}
	
  public static int[] sort(int[] arr){//This will sort the left and right arrays
    int arrL = arr.length; //gives the length of the user given arr
    int[] ls;
    int[] rs;
    if (arrL == 1) { //If arrL is 1, there is only one in in the array so return itself
      return arr;
    }
    else{
      int m = arrL/2; //Find the middle so we can separate array into left and right arrays

      int[] leftArr = new int[m]; //After original array is divided this will be the left side of the arrays
      int[] rightArr = new int[(arrL-m)]; //After original array is divided this will be the right side of the arrays

      for(int i = 0; i<m; i++){ // left arr will be from 0 to m
        leftArr[i]=arr[i];
      }
      int j = 0;
      for(int i = m; i<arrL; i++){ // right arr will be from m+1 to arrL
        rightArr[j]=arr[i];
        j++;
      }

      /**/
      //Debugging what is in left arr and what is in rightArr
      String la = ""; //This will be added to the array list once it's done collecting this array
      //System.out.print("\nLeft Array: \n[");
      la = la + "\n\nLeft Array: \n[";
      
      for(int i = 0; i<leftArr.length; i++){ //adds numbers that make the left array to a String
        //System.out.print(" "+ leftArr[i] + " ");
        la = la + " "+ leftArr[i] + " ";
      }
      //System.out.println("]");
      la = la + "]";
      //System.out.println("check 1");
      msAL.add(la);
      
      //System.out.println("check 2");
      
      String ra = ""; //This will be added to the array list once it's done collecting this array
      //System.out.print("Right Array: \n[");
      ra = ra + "\nRight Array: \n[";
      for(int i = 0; i<rightArr.length; i++){//adds numbers that make the right array to a String
        //System.out.print(" "+ rightArr[i]+ " ");
        ra = ra + " "+ rightArr[i]+ " ";
      }
      //System.out.println("]");
      ra = ra + "]";
      msAL.add(ra);

      ls = sort(leftArr);//recursively calls sort on the left arr
      rs = sort(rightArr);//recursively calls sort on the right arr
    }

    return merge(ls, rs);//calls the merge method
  }
  public static int[] merge(int[] l,int[] r){//This will merge the left and right arrays
    int len = l.length+r.length;
    int[] b = new int[len];//creates a new temporary array
    int i = 0;
    int j = 0;
    for(int k = 0; k<b.length; k++){ //Want to fill up the b array
      if (j>=r.length || (i<=(l.length-1) && l[i]<=r[j])){ //if j is greater than the length of r you want to use i to avoid error
        b[k] = l[i];                                //if i is less than length of r, you can use i. checking the values of larr and rarr
        i++;                                        //will compare the values and return the smaller one
      }else{
        b[k] = r[j];
        j++;
      }
    }
    
    String mlra = "";//This will be added to the array list once it's done collecting this array

    //System.out.println("\nMerging Left and Right Arrays in Sorted Order:");
    mlra = mlra + "\n\nMerging Left and Right Arrays in Sorted Order:\n";
    msAL.add(mlra);
    //System.out.println("Check 1: " + msAL.get(msAL.size()-1));
    //System.out.print("[");
    mlra = "[";
    
    for(int k=0;k<b.length;k++){//adds numbers that make the sorted merge array to a String
      //System.out.print(" " + b[k] + " ");
      mlra = mlra + " " + b[k] + " ";
    }
    //System.out.println("]\n");
    mlra = mlra + "]\n";
    msAL.add(mlra);
    //System.out.println("Check 2: " + msAL.get(msAL.size()-1));
    
    return b;
  }
  
  public static ArrayList getMerge() { //This will return an arraylist filled with the steps done in the sort() and merge() methods
	  return msAL;
  }

  public static void main(String[] args){
	  
	  Random rand = new Random();
	  MergeSort ms = new MergeSort();
	  Session s = new Session();
	  int[] ranNums;
	  ms.msAL = new ArrayList();
    //Creates random numbers
	/* Will now call the random method in Session.java to get the array of random numbers
    int n = 10;
    ranNums = new int[n];
    for(int i = 0; i<n; i++){
      ranNums[i] = rand.nextInt(n);
    }
    
    */
    //Creates a defined set of numbers to sort
    //int [] nums = {1,3,5,8,2,4,6,7};
    //int[] sorted = ms.sort(nums); //sorts the defined Set
    
    ranNums = s.randomNumbers(); //Creates an array of random numbers
    
    /*Shows what the unsorted array is and will add to arrayList
    //Prints out the unsorted array
    String us = "";
    System.out.println("Unsorted Array:");
    us = "Unsorted Array:\n";
    System.out.print("[");
    us = us + "[";
    for(int i=0;i<ranNums.length;i++){
      System.out.print(" " + ranNums[i] + " ");
      us = us + " " + ranNums[i] + " ";
    }
    System.out.println("]\n");
    us = us + "]";
    ms.msAL.add(us);
    */
    
    
    int[] sortedR = ms.sort(ranNums); //sorts the random array
    
    
    /*Shows what the sorted array is and will add to arrayList
    String ss = "";
    //Prints out the sorted array
    System.out.println("\nSorted Array:");
    ss = "\nSorted Array:\n";
    System.out.print("[");
    ss = ss + "[";
    for(int i=0;i<sortedR.length;i++){
      System.out.print(" " + sortedR[i] + " ");
      ss = ss + " " + sortedR[i] + " ";
    }
    System.out.print("]\n");
    ss = ss + "]";
    ms.msAL.add(ss);
    */
    
    
    /* Testing that guiSort works correctly
    ArrayList msAL2 = MergeSort.guiSort();
    System.out.println("\nArray List");
    for(int i = 0; i<msAL2.size();i++) {
    	System.out.println(msAL2.get(i));
    }
    */
    
    /* This was used to debug when my arrayList did not want to print out in the GUI
    Session session = new Session();
    ArrayList msAL2 = session.merge();
    System.out.println("\nArray List");
    for(int i = 0; i<msAL2.size();i++) {
    	System.out.println(msAL2.get(i));
    }
    */
    
  }
}
