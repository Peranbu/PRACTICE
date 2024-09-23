// Check .
//declare rows/upperD/lowerD
//base case
//check rows/upperD/lowerD
//convert res
//main class
import java.util.*;
class Main {
    // Method to solve the N-Queens problem
    public static List<List<String>> NQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> res = new ArrayList<>();
        boolean[] leftRow = new boolean[n];
        boolean[] lowerD = new boolean[2 * n - 1];
        boolean[] upperD = new boolean[2 * n - 1];
        solve(0, board, res, leftRow, lowerD, upperD);
        return res;
    }
    // Recursive method to place queens on the board
    private static void solve(int col, char[][] board, List<List<String>> res, boolean[] leftRow, boolean[] lowerD, boolean[] upperD) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (!leftRow[row] && !lowerD[row + col] && !upperD[board.length - 1 + col - row]) {
                board[row][col] = 'Q';
                leftRow[row] = true;
                lowerD[row + col] = true;
                upperD[board.length - 1 + col - row] = true;
                solve(col + 1, board, res, leftRow, lowerD, upperD);
                board[row][col] = '.';
                leftRow[row] = false;
                lowerD[row + col] = false;
                upperD[board.length - 1 + col - row] = false;
            }
        }
    }
    // Method to construct the board configuration as a list of strings
    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
    // Main method to run the program
    public static void main(String[] args) {
        int N = 4;
        List<List<String>> solutions = NQueens(N);
        int i = 1;
        for (List<String> solution : solutions) {
            System.out.println("Arrangement " + i);
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
            i++;
        }
    }
}
