class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        // if(row == 1 && col == 1){
        //     return 1;
        // }

        int dp[][] = new int[row][col];

        // for(int i=0; i<row; i++){
        //     Arrays.fill(dp[i],-1);
        // }

        int max = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
               max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        return max;
    }


    public  int dfs(int matrix[][],int i,int j,int dp[][]){
        //four direction array
        int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};

        int maxPath = 1;
        int row = matrix.length;
        int col = matrix[0].length;


        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || x >= row || y < 0 || y >= col) {
                continue;
            }

            if (matrix[x][y] > matrix[i][j]) {
                maxPath = Math.max(
                    maxPath,
                    1 + dfs(matrix, x, y, dp)
                );
            }
        }

        dp[i][j] = maxPath;
        return maxPath;
    }


}