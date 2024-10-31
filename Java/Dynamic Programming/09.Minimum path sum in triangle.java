

import java.util.*;
class Main{
    static int solve(int i,int j,int[][] tri,int n,int[][] dp){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==n-1){
            return tri[i][j]; //if i am in last row return the answer
        }
        int down=tri[i][j]+solve(i+1,j,tri,n,dp);
        int diagonal=tri[i][j]+solve(i+1,j+1,tri,n,dp);
        return dp[i][j]=Math.min(down,diagonal);
    }
    static int minimum(int[][] tri,int n){
        int[][] dp=new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,tri,n,dp); //starting from 0,0
    }
    public static void main(String[] args){
        int tri[][]={{1},{2,3},{3,6,7},{8,9,6,10}};
        int n=tri.length;
        System.out.println(minimum(tri,n));
    }
}
//time and space - N*N


//output:14
