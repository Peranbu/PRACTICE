//base case
//check wheather it is already permutated
//recurrrsion
//define the elements 
//print answer
import java util.*;
class Main{
  public static void Permutations(int[] arr,List<Integer>ds,List<List<Integer>>ans,boolean[] freq){
    if(ds.size()==arr.length){
      ans.add(new ArrayList<>(ds));
      return ;
    }
    for(int i=0;i<arr.length;i++){
      if(!freq[i]){ //check wheather it is already permutated
        freq[i]=true;
        ds.add(arr[i]);
        Permutations(arr,ds,ans,freq);
        ds.remove(ds.size()-1);
        freq[i]=false;
      }
    }
  }
  public static List<List<Integer>> PrintPermu(int[] arr){
    List<Integer>ds=new ArrayList<>();
    List<List<Integer>>ans=new ArrayList<>();
    boolean[] freq=new boolean[arr.length];
    Permutations(arr,ds,ans,freq);
    return ans;
  }
  public static void main(String[] args){
    int[] arr={1,2,3};
    List<List<Integer>> result=PrintPermu(arr);
    for(List<List<Integer>>pokkie:result){
      System.out.println(pokkie);
    }
  }
}
