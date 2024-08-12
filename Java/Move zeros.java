import java.util.*;
public class Main{
  public static void main(String[] args){
    int array[]={0,1,0,2,0,4,5,0,6};
    int n=array.length;
    int j=-1;
    for(int i=0;i<n;i++){
      if(array[i]==0){    // Finding the occurances of 0
        j=i;
        break;
      }
    }
    if(j==-1){
      System.out.println(Arrays.toString(array));  //if 0 is not present 
    }
    for(int i=j+1;i<n;i++0{
      if(array[i]!=0){     //Swaping the zeros
        swap(array,i,j);
        j++;
      }
    }
    System.out.println(Arrays.toString(array));
  }
  public static void swap(int array[],int i,int j){  //Code to swap the elements
    int temp=array[i];
    array[i]=array[j];
    array[j]=temp;
  }
}

/*

output:1,2,4,5,,6,0,0,0,0

*/



