import java.util.Scanner;
import java.util.Arrays;
public class main{
  public static void main(String args[]){
    Scanner scanner=new Scanner(System.in);
    int len=scanner.nextInt();
    int[] arr=new int[len];
    for(int i=0;i<len;i++){
      System.out.println("enter number"+(i+1)+":");
      arr[i]=scanner.nextInt();
    }
    Arrays.sort(arr);
    System.out.println("ascending order"+Arrays.toString(arr));
    //descending order
    for(int i=0;i<len/2;i++){
      int temp=arr[i];
      arr[i]=arr[len-i-1];
      temp=arr[len-1-i];
    }
    System.out.println("descending Order"+Arrays.toString(arr));
    scanner.close();
  }
}




import java.util.Arrays;
import java.util.Collections;
public class SortArray {
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 8, 1, 3};
        // Sort the array in ascending order
        Arrays.sort(arr);
        System.out.println("Sorted array in ascending order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        // Sort the array in descending order
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("Sorted array in descending order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

    
