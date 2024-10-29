import java.util.*;
class Main{
    static int solveAnswer(int i,int j,int[][] matrix,int[][] dp){//base cases
        if(i==0 && j==0){
            return matrix[0][0]; 
        }if(i<0||j<0){
            return (int)Math.pow(10,9);  //return a very large value
        }if(dp[i][j]!=-1){
            return dp[i][j];
        }
      //solving the question 
        int up=matrix[i][j]+solveAnswer(i-1,j,matrix,dp); //iterate through row
        int left=matrix[i][j]+solveAnswer(i,j-1,matrix,dp);  //iterate through column
        return dp[i][j]=Math.min(up,left); 
    }
    static int solve(int m,int n,int[][] matrix){
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solveAnswer(m-1,n-1,matrix,dp);
    }
    public static void main(String[] args){
        int[][] matrix={{5,9,6},{11,5,2}};
        int m=matrix.length;
        int n=matrix[0].length;
        System.out.println(solve(m,n,matrix));
    }
}
