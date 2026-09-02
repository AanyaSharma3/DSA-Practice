class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> list = new LinkedList<>();
        int n = security.length;
        int count = 0;
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        //prefix based condition
        //i=0 always 0 in this case
        for(int i=1; i<n; i++){
            //non-increasing/decreasing
            if(security[i]<=security[i-1]){
                count++;
            }else{
                count = 0;
            }

            prefix[i] = count;
        }

        count = 0;
        
        //suffix based condition
        for(int i=n-2; i>=0; i--){
            //non-decreasing/increasing
            if(security[i]<=security[i+1]){
                count++;
            }else{
                count = 0;
            }

           suffix[i] = count;
        }

        for(int i=0; i<n; i++){
            if(prefix[i]>=time && suffix[i]>=time){
                list.add(i);
            }
        }

        return list;
    }
}