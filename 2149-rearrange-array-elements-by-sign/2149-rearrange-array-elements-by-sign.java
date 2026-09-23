class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        //positive and negative array create for store separate val
        int positive[] = new int[n/2];
        int negative[] = new int[n/2];

        int result[] = new int[n];
        int pi = 0;
        int ni = 0;

        //values store
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                positive[pi++] = nums[i];
            }else{
                negative[ni++] = nums[i];
            }
        }

        //result store
        int k = 0;
        for(int i=0; i<n/2; i++){
            result[k++] = positive[i];
            result[k++] = negative[i];
        }

        return result; 
    }
}