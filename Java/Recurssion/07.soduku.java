//check . in input
//is it is Valid replace with numbers(c)
//isValid condition
//print Answer
//Main class
import java.util.*;
class Main{
    public static boolean solveSoduku(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){  // the board contains char [char[][] baord] 
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(solveSoduku(board)){
                                return true;
                            }else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board,int row,int col,char c) {
        for(int i=0;i<9;i++){
            // Check the row
            if(board[row][i]==c) return false;
            // Check the column
            if(board[i][col]==c) return false;
            // Check the 3x3 subgrid
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;
        }
        return true;
    }
    public static void printAnswer(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        if (solveSoduku(board)) {
            System.out.println("Sudoku solved successfully:");
            printAnswer(board);
        } else {
            System.out.println("Unable to solve the Sudoku puzzle.");
        }
    }
}
