class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        //transpose of matrix or diagonal reversing
        for(int i=0; i<row; i++){
            for(int j=i+1; j<col; j++){
                int copy = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = copy;
            }
        }

        //left and right reverse
        for(int i=0; i<row; i++){
            for(int j=0; j<col/2; j++){
                int copy = matrix[i][col-1-j];
                matrix[i][col-1-j] = matrix[i][j];
                matrix[i][j] = copy;
            }
        }
        
    }
}