class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int l_left[] = new int[n]; //low from left
        int l_right[] = new int[n]; //low from right

        //initialise the array
        l_left[0] = -1;
        l_right[n-1] = n;

        //left filling
        for(int i=1; i<n; i++){
            int idx = i-1;
            while(idx >= 0){
                if(heights[idx] >= heights[i]){
                    idx = l_left[idx];
                }else{
                    break;
                }
            }

            l_left[i] = idx;
        }


        //rightt filling
        for(int i=n-2; i>=0; i--){
            int idx = i+1;
            while(idx < n){
                if(heights[idx] >= heights[i]){
                    idx = l_right[idx];
                }else{
                    break;
                }
            }

            l_right[i] = idx;
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            int calc = (l_right[i] - l_left[i] -1) * (heights[i]);
            ans = Math.max(ans , calc);
        }

        return ans;
    }
}