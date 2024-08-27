// convert the rows and columns into 0 which contains 0
import java.util.*;
public class Main{
    static void markRow(int[][] matrix,int n,int m,int i){
        for(int j=0;j<m;j++){
            if(matrix[i][j]!=0){
                matrix[i][j]=-1;
            }
        }
    }
    static void markCol(int[][] matrix,int n,int m,int j){
        for(int i=0;i<m;i++){
            if(matrix[i][j]!=0){
                matrix[i][j]=-1;
            }
        }
    }
    static void zeroMatrix(int[][] matrix,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    markRow(matrix,n,m,i);
                    markCol(matrix,n,m,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
    }
        public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        int n=matrix.length;
        int m=matrix[0].length;
        zeroMatrix(matrix, n, m);
        System.out.println("The Final matrix is: ");
        for (int[] row:matrix) {
            for (int ele:row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}


/*
output
1 0 1 
0 0 0 
1 0 1
*/
