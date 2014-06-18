public class Solution {
    int solutionNum = 0;
    ArrayList<int[]> mark(char[][] board, int row, int col){
        int n = board.length;
        board[row][col] = 'Q';
        ArrayList<int[]> marks = new ArrayList<int[]>();
        for(int i=0;i<n;i++){
            if(board[row][i]=='\0'){
                board[row][i] = '.';
                marks.add(new int[]{row, i});
            }
            if(board[i][col]=='\0'){
                board[i][col] = '.';
                marks.add(new int[]{i, col});
            }
            if(row+i>=0&&row+i<n&&col+i>=0&&col+i<n&&board[row+i][col+i]=='\0'){
                board[row+i][col+i] = '.';
                marks.add(new int[]{row+i, col+i});
            }
            if(row-i>=0&&row-i<n&&col-i>=0&&col-i<n&&board[row-i][col-i]=='\0'){
                board[row-i][col-i] = '.';
                marks.add(new int[]{row-i, col-i});
            }
            if(row+i>=0&&row+i<n&&col-i>=0&&col-i<n&&board[row+i][col-i]=='\0'){
                board[row+i][col-i] = '.';
                marks.add(new int[]{row+i, col-i});
            }
            if(row-i>=0&&row-i<n&&col+i>=0&&col+i<n&&board[row-i][col+i]=='\0'){
                board[row-i][col+i] = '.';
                marks.add(new int[]{row-i, col+i});
            }
        }
        return marks;
    }

    void unmark(char[][] board, int row, int col, ArrayList<int[]> marks){
        board[row][col] = '\0';
        for(int i=0;i<marks.size();i++){
            int[] mark = marks.get(i);
            board[mark[0]][mark[1]] = '\0';
        }
    }

    void solveNQueensRecursive(char[][] board, int n, int row){
        if(row==n-1){
            for(int i=0;i<n;i++){
                if(board[row][i]=='\0'){
                    board[row][i] = 'Q';
                    String[] solution = new String[n];
                    solutionNum++;
                    board[row][i] = '\0';
                    return;
                }
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(board[row][i]!='\0') continue;
            ArrayList<int[]> marks = mark(board, row, i);
            solveNQueensRecursive(board, n, row+1);
            unmark(board, row, i, marks);
        }
        return;
    }

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        solveNQueensRecursive(board, n, 0);
        return solutionNum;
    }
}
