import java.util.*;
class Main{
  public static void main(String[] args){
    int height[]={30,10,60,10,60,50};
    int n=height.length;
    int dp[]=new int[n];
    Arrays.fill(dp,-1);
    dp[0]=0;
    for(int i=1;i<=n;i++){
      int jump_two=Integer.MAX_VALUE;
      int jump_one=dp[i-1]+Math.abs(height[i]-height[i-1]);
      if(i>1){
        jump_two=dp[i-2]+Math.abs(height[i]-height[i-1]);
      }
     dp[i]= Math.min(jump_one,jump_two);
    }
    System.out.println(dp[n-1]);
  }
}
