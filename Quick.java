import java.util.Random;
import java.util.Arrays;

public class Quick{
    public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
  private static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  private static int getMedian(int[] data, int start, int end){
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
}
