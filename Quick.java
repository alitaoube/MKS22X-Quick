import java.util.Random;
import java.util.Arrays;

public class Quick{
  public static void main(String[] args) {
    int[] data = {1, 5,2 ,3,6, 9, 1, 5, 2, 3, 6 ,9};
    partitionDutch(data, 0, data.length - 1);
    System.out.print(toString(data));
  }
  private static void swap(int[] arr, int x, int y) {
    // swaps index x with index y
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  private static int getMedian(int[] data, int start, int end){
    // returns the middle value of the start, end, and the middle numbers of the array
    int first = data[start];
    int middle = data[start + (end - start) / 2];
    int last = data[end];
    int median = start;

    if ((first <= last && first >= middle) || (first >= last && first <= middle)) median = start;
    if ((last <= first && last >= middle) || (last >= first && last <= middle)) median = end;
    if ((middle <= last && middle >= first) || (middle >= last && middle <= start)) median = start + (end - start) / 2;

    return median;
  }

 public static int partition (int [] data, int start, int end){
    if (start == end) return start;
    int pivot = getMedian(data, start, end);

    int pivotData = data[pivot];

    swap(data, start, pivot);  // moves pivot to beginning and adjusts pivot;
    pivot = start;
    int x = 0;

    while (end > start) {
      // swaps if it's equal half of the time
      if (data[start] == pivotData){
        x++;
        if (x % 2 == 0){
          swap(data, start, end);
          end--;
        }
      }
      if ((data[start] > pivotData)) { // if value is greater than pivot value, move to the end
          swap(data, start, end);
          end--;
        }
      else start++; // else, skip it
    }

      if (data[start] < pivotData) { // if value at start is less than pivot value, switch
        swap(data, start, pivot);
        return start;
      }
      else {
        swap(data, start - 1, pivot); // otherwise, switch with the value before it
        return start - 1;
      }
  }

  public static int quickselect(int[] data, int k){
    int start = 0;
    int end = data.length - 1;
    int pivot = partition(data, start, end); // partition it

    while (k!= pivot){
      pivot = partition(data, start, end); // keep partitioning it until it has what you are looking for.
      if (k < pivot) end = pivot - 1;
      else start = pivot + 1;
    }
    return data[k];
  }

  public static void quicksort(int[] data){
    quickSortH(data, 0, data.length - 1);
  }

  private static void quickSortH(int[] data, int start, int end){
    if (start >= end) return;
    int pivot = partition(data, start, end);

    // do not use the pivot; use values around it
    quickSortH(data, start, pivot - 1);
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

  private static int[] partitionDutch(int[] data, int lo, int hi){

    int pivot = getMedian(data, lo, hi);
    int pivotData = data[pivot];

    swap(data, lo, pivot);

    int lt = lo;
    int idx = 0;
    int gt = hi;

    while (idx <= gt){
      if (data[idx] > pivot){
        swap(data, idx, gt); // basically the same process as before; greater, put at end.
        gt--;
      }
      if (data[idx] < pivot){ // if its less than, you put it at the beginning, but increment lt to reflect that equal ones are pushed up one
        swap(data, idx, lt);
        lt++;
        idx++;
      }
      else{
        idx++; // last scenario is that they're equal, in which case you can just skip it.
      }
    }

    int[] arr = {lt, gt};
    return arr;
  }
}
