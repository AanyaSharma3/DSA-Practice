class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //minheap create and store element
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int integer:arr){
            if(k>0){
                pq.offer(integer);
                k--;
            }else if(Math.abs(pq.peek()-x)>Math.abs(x-integer)){
                pq.poll();
                pq.offer(integer);
            }
        }

        //list m store krke return
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }

        return list;
    }
}