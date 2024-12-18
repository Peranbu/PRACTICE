import java.util.*;
public class Main{
  public static void swap(int arr[],int a,int b){
    int temp=arr[a];
    arr[a]=arr[b];
    arr[b]=temp;
  }
  public static int sortWave(int arr[],int n){
    for(int i=0;i<arr.length;i+=2){
      if(i>0 && arr[i-1]>arr[i]){
        swap(arr,i,i-1);
      }
      if(i<n-1 && arr[i+1]>arr[i]){
        swap(arr,i,i+1);
      }
    }
  }
  public static void main(String[] args){
    int arr[]={10,90,40,2,1,5,23};
    int n=arr.length;
    sortWave(arr,n);
    for(int i:arr){
      System.out.println(i+" ");
    }
  }
}

//space complexity : O(n)
//time complexity  : O(1)
