class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int integer:nums){
            pq.add(integer);

            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}