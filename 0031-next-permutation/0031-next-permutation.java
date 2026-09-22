class Solution {
    public void swap(int nums[] , int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void rev(int nums[] , int i,int j){
        while(i<=j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }


    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;

        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        //less than
        if(i<0){
            rev(nums , 0, n-1);
        }else{
        //next greater
            int j = n-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            //swap with next greater if small
            swap(nums , i,j);

            //reverse last element
            rev(nums ,i+1,n-1);
        }
    }
}