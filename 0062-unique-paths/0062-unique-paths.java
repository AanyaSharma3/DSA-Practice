class Solution {
    public static int pathUnique(int i,int j,int m,int n,int dp[][]){
        //i,j are initial index
        //m,n are final index
        
        if(i>=m || j>=n){
            //out of bound condition
            return 0;
        }

        //reached at last index
        if(i==m-1 || j==n-1){
            return 1;
        }

        //already visited
        if(dp[i][j] != -1){
            return dp[i][j];
        }else{
            return dp[i][j] = pathUnique(i+1,j,m,n,dp)+pathUnique(i,j+1,m,n,dp);
        }
    }


    public int uniquePaths(int m, int n) {
        //dp array for store the repeatative value
        int dp[][] = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }


        return pathUnique(0,0,m,n,dp);
    }
}