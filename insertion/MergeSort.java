package insertion;
import java.util.Random;
import insertion.Session;

public class MergeSort{
	Arraylist msAL;
  public int[] sort(int[] arr){//This will sort the left and right arrays
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
        /*
        System.out.println("I: "+i);
        System.out.println("J: "+j);
        System.out.println("arr["+i+"] = " + arr[i]);
        System.out.println();
        */
        rightArr[j]=arr[i];
        j++;
      }

      /**/
      //Debugging what is in left arr and what is in rightArr
      System.out.print("\nLeft Array: \n[");
      for(int i = 0; i<leftArr.length; i++){
        System.out.print(" "+ leftArr[i] + " ");
      }
      System.out.println("]");
      
      System.out.print("Right Array: \n[");
      for(int i = 0; i<rightArr.length; i++){
        System.out.print(" "+ rightArr[i]+ " ");
      }
      System.out.println("]");

      ls = sort(leftArr);//recursively calls sort on the left arr
      rs = sort(rightArr);//recursively calls sort on the right arr
    }

    return merge(ls, rs);//calls the merge method
  }
  public int[] merge(int[] l,int[] r){//This will merge the left and right arrays
    int len = l.length+r.length;
    int[] b = new int[len];//creates a new temporary array
    int i = 0;
    int j = 0;
    for(int k = 0; k<b.length; k++){ //Want to fill up the b arr
      if (j>=r.length || (i<=(l.length-1) && l[i]<=r[j])){ //if j is greater than the len of r you want to use i to avoid error
        b[k] = l[i];                                //if i is less than len of r, you can use i. checking the values of larr and rarr
        i++;                                        //will compare the values and return the smaller one
      }else{
        b[k] = r[j];
        j++;
      }
    }

    System.out.println("\nMerging Left and Right Arrays in Sorted Order:");
    System.out.print("[");
    for(int k=0;k<b.length;k++){
      System.out.print(" " + b[k] + " ");
    }
    System.out.println("]\n");

    return b;
  }

  public static void main(String[] args){
	  Random rand = new Random();
	  MergeSort ms = new MergeSort();
	  Session s = new Session();
	  int[] ranNums;
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
    
    ranNums = s.randomNumbers();
    
    //Prints out the unsorted array
    System.out.println("Unsorted Array:");
    System.out.print("[");
    for(int i=0;i<ranNums.length;i++){
      System.out.print(" " + ranNums[i] + " ");
    }
    System.out.println("]\n");

    int[] sortedR = ms.sort(ranNums); //sorts the random array

    //Prints out the sorted array
    System.out.println("\nSorted Array:");
    System.out.print("[");
    for(int i=0;i<sortedR.length;i++){
      System.out.print(" " + sortedR[i] + " ");
    }
    System.out.print("]\n");


  }
}
