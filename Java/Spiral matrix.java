import java.util.*;
public class Main{
    public static void printSpiral(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;
        int top=0,bottom=n-1;
        int left=0,right=m-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                System.out.print(mat[top][i]+" ");
            }//top row
            top++;
            for(int i=top;i<=bottom;i++){
                System.out.print(mat[i][right]+" ");
            }//right column
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    System.out.print(mat[bottom][i]+" ");
                }
                bottom--;
            }//bottom row
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    System.out.print(mat[i][left]+" ");
                }
                left++;
            }//left column
        }
    }
    public static void main(String[] args){
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printSpiral(matrix);
        System.out.println();
    }
}
