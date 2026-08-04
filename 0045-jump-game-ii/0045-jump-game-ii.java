class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        //array creation
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        //meaning+initialise
        dp[n-1] = 0;

        //filling
        for(int i=n-2; i>=0; i--){
            int ans = Integer.MAX_VALUE;
            int steps = nums[i];
            for(int j=i+1; j<n && j<=i+steps; j++){
                if(dp[j] != -1){
                    ans = Math.min(ans,dp[j]+1);
                }
            }
            if(ans != Integer.MAX_VALUE){
            dp[i] = ans;
            }
        }

        return dp[0];
    }
}