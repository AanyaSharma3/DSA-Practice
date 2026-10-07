class Solution {
    public int longestConsecutive(int[] nums) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i:nums){
            set.add(i);
        }

        for(int i:set){
            if(!set.contains(i-1)){
                int dumy = 1;
                int num = i;

                while(set.contains(num+1)){
                    dumy++;
                    num++;
                }

                count = Math.max(dumy,count);
            }

        }

        return count;
    }
}