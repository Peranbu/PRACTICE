import java.util.*;
public class Main{
    public int[] Twosum(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException(" no sum");
    }
    public static void main(String[] args){
        Main ts=new Main();
        int[] nums={1,2,3,4,5,6,7};
        int target=13;
        int[] result=ts.Twosum(nums,target);
        System.out.println(result[0]+" "+result[1]);
    }
}

/*
output:5,6
*/
