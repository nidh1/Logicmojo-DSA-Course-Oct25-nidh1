class Solution {
    public void solveSudoku(char[][] board) {
        //your code goes 
     helper(board);
    }

    public boolean canPlace(char num, int row, int col, char[][] board){

        for(int i=0; i<9; i++){
            if(board[row][i]==num || board[i][col]==num){
                return false;
            }
        }

        int rowGroup = row/3;
        int rowGroupStart = rowGroup*3;

        int colGroup = col/3;
        int colGroupStart = colGroup*3;

        for(int i=rowGroupStart; i<=rowGroupStart+2; i++){
            for(int j=colGroupStart; j<=colGroupStart+2; j++){
                if(i==row && j==col) continue;

                if(board[i][j] == num) return false;
            }
        }

        return true;
    }

    public boolean helper(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                for(char k='1'; k<='9'; k++){
                    if(canPlace(k, i, j, board)){
                        board[i][j] = k;
                        boolean solved = helper(board);
                        if(solved){
                            return true;
                        }else{
                        board[i][j] = '.';
                    }
                    }
                }
                return false;
                }
            }
        }
        return true;
    }
}
