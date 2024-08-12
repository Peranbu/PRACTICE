import java.util.*;
public class Main{
  public static void main(String[] args){
    int array[]={1,2,3,4,5,6,7};
    int k=2;
    int n=array.length;
    leftRotate(array,k);
    for(int i=0;i<n;i++){
      System.out.print(array[i]+" ");
    }
  }
  public static void leftRotate(int array[],int d){
    int n=array.length;
    d=d%n;
    reverse(array,0,d-1); // first d elemnts
    reverse(array,d,n-1); // other elements in the d 
    reverse(array,0,n-1); //reverse the whole array to get output
  }
  public static void reverse(int array[],int start,int end){
    while(start<end){
      int temp=array[start];
      array[start]=array[end];
      array[end]=temp;
      start++;
      end--;
    }
  }
}


/*
output:3,4,5,6,7,1,2
*/
