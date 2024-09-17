//base case
//allow duplicates
//add the elements and store it in data structure
//repeat using recurssion
//input method and output format
import java.util.*;
public class Main{
  public void findCombination(int ind,int[] arr,int target,List<List<Integer>> ans,List<Integer> ds){
    if(target==0){
      ans.add(new ArrayList<>(ds));
      return;
    }
    for(int i=ind;i<arr.length;i++){
      if(i>ind && arr[i]==arr[i-1]) continue;
      if(arr[i]>target) break;
      ds.add(arr[i]);
      findCombination(i+1,arr,target-arr[i],ans,ds);
      ds.remove(ds.size()-1);
    }
  }
  public List<List<Integer>> combinationSum(int[] candidate,int target){
    List<List<Integer>> ans=new ArrayList<>();
    Arrays.sort(candidate);
    findCombination(0,candidate,target,ans,new ArrayList<>());
    return ans;
  }
  public static void main(String[] args){
    Main obj=new Main();
    int[] candidate={10,7,2,1,6,1,5};
    int target=8;
    List<List<Integer>> result=obj.combinationSum(candidate,target);
    for(List<List<Integer>> pokiee:result){
      System.out.println(pokiee);
    }
  }
}

/*
output
[1, 1, 6]
[1, 2, 5]
[1, 7]
[2, 6]


*/
