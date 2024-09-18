import java.util.*;
class Main{
  public static void SubsetSum(int ind,int sum,List<Integer> arr,int N,List<Integer> ans){
    if(ind==N){
      ans.add(sum);
      return;
    }
    SubsetSum(ind+1,sum+arr.get(ind),arr,N,ans);
    SubsetSum(ind+1,sum,arr,N,ans);
  }
  public static List<Integer> SubsetSum(List<Integer>arr,int N){
    List<Integer>ans=new ArrayList<>();
    SubsetSum(0,0,arr,N,ans);
    /*
    0-starting index
    int sum=0
    arr,N=arr.size(),ans
    */
    Collections.sort(ans);
    return ans;
  }
  public static void main(String[] args){
    List<Integer>arr=new ArrayList<>();
    arr.add(3);
    arr.add(1);
    arr.add(2);
    int N=arr.size();
    List<Integer>result=SubsetSum(arr,N);
    System.out.println(result);
  }
}
/*
output
[0, 1, 2, 3, 3, 4, 5, 6]
*/
