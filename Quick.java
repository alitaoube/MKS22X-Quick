import java.util.Random;

public class Quick{
  public static void main(String[] args) {
    int[] data = {3,1,5,2,4,10,8};
    partition(data, 0, 0);
  }

  public static int partition ( int [] data, int start, int end){
    Random rand = new Random();

    int pivot = rand.nextInt(data.length);

    System.out.print(pivot);
    System.out.println();

    int temp = data[pivot];

    data[pivot] = data[0];

    data[0] = temp;

    while (start != end){
      if (data[start] >= data[pivot]){ // If it's greater, put it at the end
        int temp1 = data[end];
        data[end] = data[start];
        data[start] = temp1;
        start++;
      }
      if (data[start] < data[pivot]){
        start++;
      }
    }

    int temp3 = data[0];
    data[0] = data[pivot];
    data[pivot] = temp3;
    System.out.print(toString(data));

    return 1;
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
