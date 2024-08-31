import java.util.*;
public class Main{
    public static void transpose(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }//transpose the matirx
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix.length/2;j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[i][matrix.length-j-1];
            matrix[i][matrix.length-j-1]=temp;
        }
    }//reverse the matrix
    }
    public static void main(String[] args){
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        transpose(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
