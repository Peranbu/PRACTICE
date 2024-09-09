import java.util.*;
public class Main{
  public List<List<Integer>> ThreeSum(int[] nums,int target){
    List<List<Integer>> target=new ArrayList<>();
    Arrays.sort(nums);
    for(int i=0;i<nums.length-2;i++){
      if(i>0 && nums[i]==nums[i-1]) continue;
      int left=i+1;
      int right=nums.length-1;
      while(left<right){
        int sum=nums[i]+nums[left]+nums[right];
        if(sum==target){
          result.add(Arrays.asList(nums[i],nums[left],nums[right]);
          while(left<right && nums[left]==nums[left-1]) left++;
          while(left<right && nums[right]==nums[right+1]) right--;
          left++;
          right--;
        }else if(sum<target){
          left++;
        }else{
          right--;
        }
      }
    }
    return result;
  }
  public static void main(String[] args){
    Main st= new main();
    int[] nums={1,2,3,4,5,6};
    int target=9;
    System.out.println(st.ThreeSum(nums,target));
  }
}
