class Solution {
    List<List<Integer>> ans;

    public void helper(int nums[] , List<Integer> curr){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return ;
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] != -11){
                int temp = nums[i];
                curr.add(temp);

                nums[i] = -11; //not visited
                helper(nums,curr);

                curr.remove(curr.size()-1);
                nums[i] = temp;

            }
        }
    }

    
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        helper(nums , new ArrayList<>());
        return ans;
    }
}