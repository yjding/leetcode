public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows
        for(int i=0;i<9;i++){
            int rowCheck = 0;
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                else if(board[i][j]-'0'>0&&board[i][j]-'0'<=9){
                    if((rowCheck&(1<<(board[i][j]-'0')))==0){
                        rowCheck ^= 1<<(board[i][j]-'0');
                    }
                    else return false;
                }
                else return false;
            }
        }
        // check columns
        for(int j=0;j<9;j++){
            int colCheck = 0;
            for(int i=0;i<9;i++){
                if(board[i][j]=='.') continue;
                else if(board[i][j]-'0'>0&&board[i][j]-'0'<=9){
                    if((colCheck&(1<<(board[i][j]-'0')))==0){
                        colCheck ^= 1<<(board[i][j]-'0');
                    }
                    else return false;
                }
                else return false;
            }
        }
        // check boxes
        for(int k=0;k<3;k++)
            for(int l=0;l<3;l++){
                int boxCheck = 0;
                for(int i=0;i<3;i++)
                    for(int j=0;j<3;j++){
                        if(board[i+3*k][j+3*l]=='.') continue;
                        else if(board[i+3*k][j+3*l]-'0'>0&&board[i+3*k][j+3*l]-'0'<=9){
                            if((boxCheck&(1<<(board[i+3*k][j+3*l]-'0')))==0){
                                boxCheck ^= 1<<(board[i+3*k][j+3*l]-'0');
                            }
                            else return false;
                        }
                        else return false;
                    }
            }
        return true;
    }
}
