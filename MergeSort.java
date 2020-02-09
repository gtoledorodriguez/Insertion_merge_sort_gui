public class MergeSort{
  public int[] sort(int[] arr){//This will sort the left and right arrays
    int[] sorted = []; //Return our final answer, after merging and sorting the left and right arrays
    int arrL = arr.length; //gives the length of the user given arr

    if (arrL == 1) { //If arrL is 1, there is only one in in the array so return itself
      sorted = arr;
    }
    else{
      int m = arrL/2; //Find the middle so we can separate array into left and right arrays

      int[] leftArr = [m]; //After original array is divided this will be the left side of the arrays
      int[] rightArr = [m]; //After original array is divided this will be the right side of the arrays

      for(int i = 0; i<=m; i++){ // left arr will be from 0 to m
        leftArr[i]=arr[i];
      }
      for(int i = m+1; i<=arrL; i++){ // right arr will be from m+1 to arrL
        rightArr[i]=arr[i];
      }

      sort(leftArr);
      sort(rightArr);
    }

    return sorted;
  }
  public int[] merge(){//This will merge the left and right arrays

  }

  public static void main(String[] args){
    int [] nums = [9,1,2,4,3,5,6,7,8]


  }
}
