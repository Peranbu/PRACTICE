import java.util.*;
public class Main{
    public void findCombinations(int ind,int[] arr,int target,List<List<Integer>>ans,List<Integer>ds){
        if(ind==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds)); //base case
            }
            return;
        }
        if(arr[ind]<=target){
            ds.add(arr[ind]);
            findCombinations(ind,arr,target-arr[ind],ans,ds); //add the number(leftmost--1st) 
            ds.remove(ds.size()-1); //remove the above added number
        }
        findCombinations(ind+1,arr,target,ans,ds); //repeat the process(left to right)
    }
    public List<List<Integer>> combinationSum(int[] candidate,int target){
        List<List<Integer>> ans=new ArrayList<>();
        findCombinations(0,candidate,target,ans,new ArrayList<>()); // store the ans
        //stack data structure is used to push all the numbers to get to the target and finally print the output
        return ans;
    }
    public static void main(String[] args){
        Main obj=new Main();
        int[] candidates={1,2,3,4,5};
        int target=4;
        List<List<Integer>> result=obj.combinationSum(candidates,target);
        for(List<Integer> okie:result){
            System.out.println(okie);
        }
    }
}
