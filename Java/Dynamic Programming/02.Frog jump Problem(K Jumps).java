import java.util.*;
class Main{
  static int solveProblem(int n,int[] height,int k,int[] dp){
    dp[0]=0;
    for(int i=1;i<n;i++){ //iteration for numbers
      int mini=Integer.MAX_VALUE;
      for(int j=1;j<=k;j++){ //for jumps
        if(i-j>=0){
          int jump=dp[i-j]+Math.abs(height[i]-height[i-j]);
          mini=Math.min(mini,jump);
        }
      }
      dp[i]=mini;
    }
    return dp[n-1];
  }
  static int solve(int n,int[] height,int k){
    int[] dp=new int[n+1];
    Arrays.fill(dp,-1);
    return solveProblem(n,height,k,dp);
  }
  public static void main(String[] args){
    int height[]={30,10,60,10,60,50};
		int n=height.length;
		int k=2;
		System.out.println(solve(n,height,k));
  }
}
