//Memorization approach 
//base case
//up and down movement
//decalre dp and row and column
//main class
import java.util.*;
class Main{
    static int countways(int i,int j,int dp[][]){
        if(i==0 & j==0){
            return 1;
        }
        if(i<0||j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=countways(i-1,j,dp);
        int down=countways(i,j-1,dp);
        return dp[i][j]=up+down;
    }
    static int cWays(int m,int n){
        int dp[][]=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return countways(m-1,n-1,dp);
    }
    public static void main(String[] args){
        int m=3;
        int n=2;
        System.out.println(cWays(m,n));
    }
}

//tabulation approach
//iterate using for loop
//base case
//up and left
//return answer upto last element
import java.util.*;
class Main{
    static int countWaysUntil(int m,int n,int[][] dp){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    dp[i][j]=1;
                    continue;
                }
                int up=0;
                int left=0;
                if(i>0){
                    up=dp[i-1][j];
                }
                if(j>0){
                    left=dp[i][j-1];
                }
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
    static int countWays(int m,int n){
        int dp[][]=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return countWaysUntil(m,n,dp);
    }
    public static void main(String[] args){
        int m=3;
        int n=2;
        System.out.println(countWays(m,n));
    }
}
