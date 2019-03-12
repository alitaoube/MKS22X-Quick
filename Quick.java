import java.util.Random;

public class Quick{
  public static void main(String[] args) {
    int[] data = {0, 999,999,999,999,1,2,3,4};
    partition(data, 0, data.length - 1);
  }

  private static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public static int partition ( int[] data, int start, int end){

	    int pivot = (int) (Math.random() * (data.length - 1));
	    int pivotData = data[pivot];

	    swap(data, start, pivot);
	    start++;



	    while (end != start){
	      if (data[start] > pivotData){ // If it's greater, put it at the end
	        swap(data, start, end);
	        end--;
	      }
	      else{
	        start++;
	      }
	    }

	    if (data[start] < pivotData){
	      swap(data, start, 0); // At the end, if num at 0 is less than the pivot at 0, switch
	      return start;
	    }
	    else{
	      swap(data, start - 1, 0); // If data[start ] > pivot, that means the num right before it is less than pivot
        System.out.print(toString(data));
	      return start - 1;
	    }
	  }

  public static String toString(int[] data){
    String output = "";
    for (int x: data){
      output += x;
      output += ' ';
    }
    return output;
  }


}
