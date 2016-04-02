public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length, n = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                DFS_change_state(board, i, 0);
            if (board[i][n-1] == 'O')
                DFS_change_state(board, i, n-1);
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                DFS_change_state(board, 0, j);
            if (board[m-1][j] == 'O')
                DFS_change_state(board, m-1, j);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'D'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void DFS_change_state(char[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[x].length) return;
        if (board[x][y] == 'O')
            board[x][y] = 'D';
        if (x > 1 && board[x-1][y] == 'O')
            DFS_change_state(board, x-1, y);
        if (x < board.length - 2 && board[x+1][y] == 'O')
            DFS_change_state(board, x+1, y);
        if (y > 1 && board[x][y-1] == 'O')
            DFS_change_state(board, x, y-1);
        if (y < board[x].length - 2 && board[x][y+1] == 'O' )
            DFS_change_state(board, x, y+1);
    }
}
