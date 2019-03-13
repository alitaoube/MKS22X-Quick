import java.util.Random;

public class Quick{
  public static void main(String[] args) {
    int[] data = {999,999,999,4,1,0,3,2,999,999,999};

    System.out.print(partition(data, 0, data.length - 1));
    System.out.println();
    // quicksort(data);
    System.out.print(toString(data));
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

	    while (end != start){
	      if (data[start + 1] >= pivotData){ // If it's greater, put it at the end
	        swap(data, start + 1, end);
	        end--;
	      }
	      else{
          swap(data, start, start + 1);
	        start++;
	      }
	    }
      return start;
	  }

  // public static int quickselect(int[] data, int k){
  //   partition(data, 0, 0);
  //
  //   for (int x = 0; x < data.l)
  // }

  public static void quicksort(int[] data){
    quickSortH(data, 0, data.length - 1);
  }

  private static void quickSortH(int[] data, int start, int end){
    if (start >= end) return;
    // System.out.print("START1: " + start);
    // System.out.println();
    int pivot = partition(data, start, end);

    System.out.println("DATA");
    System.out.println("PIVOT: " + pivot);
    System.out.print(toString(data));
    System.out.println();
    // System.out.println();
    // System.out.print("START: " + start);
    // System.out.println();
    // System.out.print("END: " + end);
    // System.out.println();
    // System.out.print("LENGTH: " + data.length);
    // System.out.println();
    // System.out.print("PIVOT: " + pivot);
    // System.out.println();

    quickSortH(data, start, pivot);
    quickSortH(data, pivot + 1, end);
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
