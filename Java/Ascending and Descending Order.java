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
    
