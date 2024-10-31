//N*N matrix

//memorization

import java.util.*;
class Main{
    static int solve(int i,int j,int m,int[][] matrix,int[][] dp){
        if(j<0||j>m-1){    //out of bound
            return (int) -1e9;
        }
        if(i==0){   //return 1st row
            return matrix[0][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=matrix[i][j]+solve(i-1,j,m,matrix,dp);
        int left=matrix[i][j]+solve(i-1,j-1,m,matrix,dp);
        int right=matrix[i][j]+solve(i-1,j+1,m,matrix,dp);
        return dp[i][j]=Math.max(up,Math.max(left,right));
    }
    static int sol(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int mini=Integer.MIN_VALUE; //to store the value
        for(int j=0;j<n;j++){ //iterate through column 
            int ans=solve(m-1,j,n,matrix,dp);  
            mini=Math.max(mini,ans);
        }
        return mini;
    }
    public static void main(String[] args){
        int[][] matrix={
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };
        System.out.println(sol(matrix));
    }
}

//Bottom-Up Dynamic Programming
class Main{
    static int solve(int[][] matrix){
        int n=matrix.length;
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int best=matrix[i+1][j];
                if(j>0){ //2nd row
                    best=Math.min(best,matrix[i+1][j-1]);
                }
                if(j<n-1){//1st row
                    best=Math.min(best,matrix[i+1][j+1]);
                }
                matrix[i][j]+=best;
            }
        }
        int mini=Integer.MAX_VALUE;
        for(int x:matrix[0]){
            mini=Math.min(mini,x);
        }
        return mini;
    }
    public static void main(String[] args){
        int[][] matrix={{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(solve(matrix));
    }
}

/*
Approach	Time Complexity	Space Complexity
Recursive + Memoization	O(m * n),O(m * n) (for dp and call stack)
Bottom-Up Dynamic Programming (In-Place)	O(m * n),O(1) (in-place)
*/
