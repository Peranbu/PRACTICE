import java.util.*;
public class Main{
  public static void main(String[] args){
    int arr[]={2,3,1,4,5,6,7};
    int n=arr.length;
    int temp=arr[0];
    for(int i=1;i<n;i++){
      arr[i-1]=arr[i] //Inside the loop, this line shifts the element at index i to the position i-1
        }
    arr[n-1]=temp; //Updates last element
    System.out.println(Arrays.toString(arr))l
      }
}


/*
output:3,1,4,5,6,7,2
*/
