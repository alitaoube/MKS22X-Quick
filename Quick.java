import java.util.Random;

public class Quick{
  public static void main(String[] args) {
    int[] data = {999,999,999,4,1,0,3,2,999,999,999};
    partition(data, 0, data.length - 1);
    toString(data);
  }

  private static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public static int partition ( int[] data, int start, int end){

	    int pivot = (int) (Math.random() * (data.length - 1));
      int pivotData = data[pivot];
      // int pivot = new Random().nextInt(end - start + 1);

      System.out.print("PIVOT : " + pivot);
      System.out.println();
      System.out.print("PIVOTDATA : " + pivotData);
      System.out.println();

	    swap(data, start, pivot);
	    start++;

	    while (end != start){
	      if (data[start] >= pivotData){ // If it's greater, put it at the end
	        swap(data, start, end);
	        end--;
	      }
	      else{
	        start++;
	      }
	    }

	    if (data[start] < pivotData){
	      swap(data, start, 0); // At the end, if num at 0 is less than the pivot at 0, switch
        System.out.print(toString(data));
        return start;
	    }
	    else{
	      swap(data, start - 1, 0); // If data[start ] > pivot, that means the num right before it is less than pivot
        System.out.print(toString(data));
	      return start - 1;
	    }
	  }

  public static int quickselect(int[] data, int k){
    return -1;
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
