//memorization
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
//at maximum condition -- O(M*N)
//space -- O(M-1)+O(N-1)+O(M*N)


//tabulation
import java.util.*;
class Main {
    static int minimumPath(int m, int n, int[][] matrix) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if (i > 0) {
                        up = matrix[i][j] + dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = matrix[i][j] + dp[i][j - 1];
                    }
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    public static void main(String[] args) {
        int[][] matrix = { {5, 9, 6}, {11, 5, 2} };
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println(minimumPath(m, n, matrix));
    }
}

// time complexity-O(M*N) -- 2 nested loops
//space-- O(M*N)
