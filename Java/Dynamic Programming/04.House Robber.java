class Main{
    public static int robb(int[] arr,int start,int end){
        if(start==end) return arr[start];
        int[] dp=new int[arr.length];
        dp[start]=arr[start];
        dp[start+1]=Math.max(arr[start],arr[start+1]);
            for(int i=start+2;i<=end;i++){
                dp[i]=Math.max(dp[i-1],arr[i]+dp[i-2]);
            }
            return dp[end];
        }
        public static int house(int[] nums){
            if(nums.length==0) return 0;
            if(nums.length==1) return nums[0];
            return Math.max(robb(nums,0,nums.length-2),robb(nums,1,nums.length-1));
        }
        public static void main(String[] args){
            int[] nums={2,3,2};
            System.out.println(house(nums));
        }
}

//output:4

