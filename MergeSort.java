public class MergeSort{
  public int[] sort(int[] arr){//This will sort the left and right arrays
    int arrL = arr.length; //gives the length of the user given arr
    int[] ls;
    int[] rs;
    if (arrL == 1) { //If arrL is 1, there is only one in in the array so return itself
      return arr;
    }
    else{
      //System.out.println(arrL);
      int m = arrL/2; //Find the middle so we can separate array into left and right arrays
      //System.out.println(m);
      int[] leftArr = new int[m]; //After original array is divided this will be the left side of the arrays
      int[] rightArr = new int[m]; //After original array is divided this will be the right side of the arrays

      for(int i = 0; i<m; i++){ // left arr will be from 0 to m
        //System.out.println("");
        //System.out.println("I1: "+i);
        leftArr[i]=arr[i];
      }
      int j = 0;
      for(int i = m+1; i<arrL; i++){ // right arr will be from m+1 to arrL
        //System.out.println("");
        //System.out.println("I2: "+i);
        //System.out.println("J1: "+j);
        rightArr[j]=arr[i];
        j++;
      }

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
      //System.out.println("");
      //System.out.println("K1: "+k);
      //System.out.println("I3: "+i);
      //System.out.println("J2: "+j);
      //System.out.println("r.length:" + r.length);
      //System.out.println("j>=r.length: " + (j>=r.length));
      //System.out.println("l["+i+"] = " + l[i]);
      //System.out.println("r["+j+"] = " + r[j]);
      if (j>=r.length || (i<=(l.length-1) && l[i]<=r[j])){ //if j is greater than the len of r you want to use i to avoid error
        b[k] = l[i];                                //if i is less than len of r, you can use i. checking the values of larr and rarr
        i++;                                        //will compare the values and return the smaller one
      }else{
        b[k] = r[j];
        j++;
      }
    }

    return b;
  }

  public static void main(String[] args){
    MergeSort ms = new MergeSort();
    int [] nums = {9,1,2,4,3,5,6,7,8};

    int[] sorted = ms.sort(nums);

    for(int i=0;i<sorted.length;i++){
      System.out.println(sorted[i]);
    }
  }
}
