public class Solution {
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

    void solveNQueensRecursive(ArrayList<String[]> solutions, char[][] board, int n, int row){
        if(row==n-1){
            for(int i=0;i<n;i++){
                if(board[row][i]=='\0'){
                    board[row][i] = 'Q';
                    String[] solution = new String[n];
                    for(int j=0;j<n;j++){
                        solution[j] = new String(board[j]);
                    }
                    solutions.add(solution);
                    board[row][i] = '\0';
                    return;
                }
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(board[row][i]!='\0') continue;
            ArrayList<int[]> marks = mark(board, row, i);
            solveNQueensRecursive(solutions, board, n, row+1);
            unmark(board, row, i, marks);
        }
        return;
    }

    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> solutions = new ArrayList<String[]>();
        char[][] board = new char[n][n];
        solveNQueensRecursive(solutions, board, n, 0);
        return solutions;
    }
}
