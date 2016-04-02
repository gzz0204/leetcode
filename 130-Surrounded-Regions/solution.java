public class Solution {
    public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            if(i == 0 || i == board.length-1){
                for(int j = 0; j < board[i].length; j++){
                    DFS_change_state(board, i, j);
                }   
            }else{
                DFS_change_state(board, i, 0);
                DFS_change_state(board, i, board[i].length-1);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'D'){
                    board[i][j] = 'O';
                }
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void DFS_change_state(char[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[x].length) return;
        if(board[x][y] == 'X' || board[x][y] == 'D') return;
        board[x][y] = 'D';
        DFS_change_state(board, x-1,y);
        DFS_change_state(board, x+1,y);
        DFS_change_state(board, x,y-1);
        DFS_change_state(board, x,y+1);
    }
}