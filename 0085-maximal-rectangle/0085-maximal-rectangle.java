class Solution {
    public int largeArea(int dp[]){
        int n = dp.length;
        int l_left[] = new int[n]; //low from left
        int l_right[] = new int[n]; //low from right

        l_left[0] = -1;
        l_right[n-1] = n;

        //left filling
        for(int i=1; i<n; i++){
            int idx = i-1;
            while(idx >= 0){
                if(dp[idx] >= dp[i]){
                    idx = l_left[idx];
                }else{
                    break;
                }
            }

            l_left[i] = idx;
        }


        //right filling
        for(int i=n-2; i>=0; i--){
            int idx = i+1;
            while(idx < n){
                if(dp[idx] >= dp[i]){
                    idx = l_right[idx];
                }else{
                    break;
                }
            }

            l_right[i] = idx;
        }


        int ans = 0;

        for(int i=0; i<dp.length; i++){
            int calc = (l_right[i] - l_left[i] - 1) * (dp[i]);
            ans = Math.max(ans , calc);
        }

        return ans;

    }


    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int dp[] = new int[c];
        int max = 0;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(matrix[i][j] == '1'){
                    dp[j] = dp[j] + 1;
                }else if(matrix[i][j] == '0'){
                    dp[j] = 0;
                }
            }

            max = Math.max(max , largeArea(dp));
        }

        return max;
    }
}