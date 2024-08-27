import java.util.*;
public class Main{
  public static int[] genLeader(int[] arr,int n){
    int[] leader=new int[n];
    int index=0;
    int max=arr[n-1];
    leader[index++]=max;
    for(int i=n-2;i>=0;i--){
      if(arr[i]>max){
        max=arr[i];
        leader[index++]=max;
      }
    }
    return Arrays.copyOfRange(leader,0,index);
  }
  public static void main(String[] args){
    int n=6;
    int[] arr={10,22,12,3,0,6};
    int ans[]=genLeader(arr,n);
    Arrays.sort(ans);
    for(int i=ans.length-1;i>=0;i--){
      System.out.println(ans[i]+" ");
    }
  }
}
