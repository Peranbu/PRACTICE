import java.util.*;
class Main{
    public static int solve(int[] nums,int low,int high,int target){
        if(low>high) return -1;
        int mid=(low+high)/2;
        if(nums[mid]==target){
            return mid;
        }else if(target>nums[mid]){
            return solve(nums,mid+1,high,target); //moving mid to the right side 
        }else{
            return solve(nums,low,mid-1,target); //moving mid to the left side
        }
    }
    public static int answer(int[] nums,int target){
        return solve(nums,0,nums.length-1,target);
    }
    public static void main(String[] args){
        int[] nums={3,4,5,6,7};
        int target=5;
        int ind=answer(nums,target);
        if(ind==-1){
            System.out.println("no ansqwre");
        }else{
            System.out.println("answer " + ind);
        }
    }
}

