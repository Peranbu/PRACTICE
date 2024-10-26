//memorization approach
//if -1 it is not possible
//base case
//up and left
//return answer

import java.util.*;
class Main{
  static int solveAnswer(int i,int j,int[][] maze,int[][] dp){
    if(i>=0 && j>=0 && maze[i][j]==-1){
      return 0;
    }
    if(i<0||j<0){
      return 0;
    }
    if(i==0 && j==0){
      return 1;
    }
    if(dp[i][j]!=-1){
      return dp[i][j];
    }
    int up=solveAnswer(i-1,j,maze,dp);
    int left=solveAnswer(i,j-1,maze,dp);
    return dp[i][j]=up+left;
  }
  static int Answer(int m,int n,int[][] maze){
    int dp[][]=new int[m][n];
    for(int row[]:dp){
      Arrays.fill(row,-1);
    }
    return solveAnswer(m-1,n-1,maze,dp);
  }
  public static void main(String[] args){
    int[][] maze={{0,0,0},{0,-1,0},{0,0,0}};
    int m=maze.length;
    int n=maze[0].length;
    System.out.println(Answer(m,n,maze));
  }
}

//Tabulation approachh
import java.util.*;
class Main{
    static int countWaysUntil(int m,int n,int[][] maze,int[][] dp){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>=0&&j>=0 &&maze[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
              if(i==0 && j==0){
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
    static int countWays(int m,int n,int[][] maze){
        int dp[][]=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return countWaysUntil(m,n,maze,dp);
    }
    public static void main(String[] args){
        int[][] maze={{0,0,0},{0,-1,0},{0,0,0}};
        int m=maze.length;
        int n=maze[0].length;
        System.out.println(countWays(m,n,maze));
    }
}
