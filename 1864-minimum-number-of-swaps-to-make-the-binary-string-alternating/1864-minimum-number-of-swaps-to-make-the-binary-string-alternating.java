class Solution {
    public int minSwaps(String s) {
        int count0 = 0;
        int count1 = 0;
        int miss0 = 0;
        int miss1 = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                count0++;
            }else{
                count1++;
            }
        }

        if(Math.abs(count0 - count1)>1){
            return -1;
        }

        for(int i=0; i<s.length(); i++){
            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if(s.charAt(i) != expected0){
                miss0++;
            }

             if(s.charAt(i) != expected1){
                miss1++;
            }
        }

         
        int ans = Integer.MAX_VALUE;

        if (count0 >= count1) {
            ans = Math.min(ans, miss0 / 2);
        }

        if (count1 >= count0) {
            ans = Math.min(ans, miss1 / 2);
        }

        return ans;
    }
}