//Get input
import java.util.Scanner;
public class main{
  public static void main(String args[]){
    Scanner numberinput=new Scanner(System.in);
    System.out.println("enter the lenght of the array");
    int len=numberinput.nextInt();
    int[] arr=new int[len];
    for(int i=0;i<len;i++){
      System.out.println("element "+ (i+1) +":");
      arr[i]=numberinput.nextInt();
    }
//Sort the given array
  for(int i=0;i<len;i++){
    for(int j=i+1;j<len;j++){
      if(arr[i]>arr[j]){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
      }
    }
  }
//Get m and n vales
  System.out.println("enter the value of m");
  int m=numberinput.nextInt();
  System.out.println("enter the value of n");
  int n=numberinput.nextInt();
  int max=arr[len-m];
  int min=arr[n-1];
  System.out.println(m + " maximum number = " + max);
        System.out.println(n + " minimum number = " + min);
        System.out.println("Sum = " + (max + min));
        System.out.println("Difference = " + (max - min));
        // Close the scanner
        numberinput.close();
    }
}
