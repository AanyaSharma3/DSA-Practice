class Solution {
    public String reorganizeString(String s) {
        int freqCount[] = new int[26]; //char count
        for(char ch:s.toCharArray()){
            freqCount[ch-'a']=freqCount[ch-'a']+1;
        }

        //maxHeap -> char , freq
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));

        for(int i=0; i<26; i++){
            if(freqCount[i] > 0){
                maxHeap.offer(new int[]{i+'a',freqCount[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        int block[] = maxHeap.poll();
        sb.append((char)block[0]);
        block[1]--;

        while(!maxHeap.isEmpty()){
            int next[] = maxHeap.poll();
            sb.append((char)next[0]);
            next[1]--;
            if(block[1]>0){
                maxHeap.offer(block);
            }
            block = next;
        }

        if(block[1] > 0){
            return "";
        }else{
            return sb.toString();
        }
    }
}