public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        if(grid[0].length == 0){
            return 0;
        }
        char[][] matrix = new char[grid.length][grid[0].length];
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                matrix[row][col] = grid[row][col];
            }
        }
        int res = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(matrix[row][col] == '1'){
                    res ++;
                    destroyIsland(matrix, row, col);
                }
            }
        }
        return res;
    }
    private void destroyIsland(char[][] matrix, int row, int col){
        // 1 -> 0
        if(matrix[row][col] == '0'){
            return;
        }
        matrix[row][col] = '0';
        if(row - 1 >= 0 && matrix[row-1][col] == '1'){
            destroyIsland(matrix, row-1, col);
        }
        if(col - 1 >= 0 && matrix[row][col-1] == '1'){
            destroyIsland(matrix, row, col-1);
        }
        if(row + 1 < matrix.length && matrix[row + 1][col] == '1'){
            destroyIsland(matrix, row+1, col);
        }
        if(col + 1 < matrix[row].length && matrix[row][col+1] == '1'){
            destroyIsland(matrix, row, col+1);
        }
    }
}
