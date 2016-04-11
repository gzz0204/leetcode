public class Solution {

    public void rotate(int[][] matrix) {
        int tmp = 0;
        int n = matrix.length;
        for(int row = 0; row <= (n/2 - 1); row++){
            for(int col = 0; col < n; col++){
                tmp = matrix[row][col];
                matrix[row][col] = matrix[n-1-row][col];
                matrix[n-1-row][col] = tmp;
            }
        }
        for(int row = 0; row < n; row++){
            for(int col = row+1; col < n; col++){
                //matrix[row][col] <-> matrix[col][row]
                tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
    }
    public void rotate2(int[][] matrix) {
        if(matrix.length != 0){
            int n = matrix.length;
            for(int row = 0; row < n / 2; row++){
                for(int col = row; col < n - 1 - row; col++){
                    int tmp1 = 0;

                    tmp1 = matrix[col][n-1-row];
                    matrix[col][n-1-row] = matrix[row][col];
                    matrix[row][col] = tmp1;

                    tmp1 = matrix[n-1-row][n-1-col];
                    matrix[n-1-row][n-1-col] = matrix[row][col];
                    matrix[row][col] = tmp1;

                    tmp1 = matrix[n-1-col][row];
                    matrix[n-1-col][row] = matrix[row][col];
                    matrix[row][col] = tmp1;
                }
            }
        }
    }
}
