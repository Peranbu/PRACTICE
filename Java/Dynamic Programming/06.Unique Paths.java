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
