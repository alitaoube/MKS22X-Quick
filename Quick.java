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
    Random rand = new Random();

    int pivot = rand.nextInt(data.length);
    System.out.print("IDX :" + pivot + "\n");

    int pivotData = data[pivot];


    System.out.print("PIVOTDATA: " + pivotData);

    swap(data, start, pivot);
    System.out.println("FIRST: " + toString(data));

    System.out.print("PIVOT: " + data[pivot] + "\n");

    start++;



    while (end != start){
      System.out.print(toString(data) + "\n");
      if (data[start] > pivotData){ // If it's greater, put it at the end
      // System.out.print("SWAP TO END");
      // System.out.println();
      //
      //   System.out.print("START: "+ data[start]);
      //   System.out.println();
      //
      //   System.out.print("END: "+ data[end]);
      //   System.out.println();

        swap(data, start, end);
        end--;
      }
      else{
        start++;
      }
      // else if (data[start] == pivotData){
      //   start++;
      // }
    }

    if (data[start] < pivotData){
      swap(data, start, 0); // At the end, if num at 0 is less than the pivot at 0, switch
      return start;
    }
    else{
      swap(data, start - 1, 0); // If data[start ] > pivot, that means the num right before it is less than pivot
      return start - 1;
    }

    // System.out.print(toString(data));
    // return pivot;
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
