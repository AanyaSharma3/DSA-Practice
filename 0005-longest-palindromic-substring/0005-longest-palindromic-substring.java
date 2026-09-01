class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 1;
        int left = 0;
        int right = 0;

        for(int i=0; i<s.length(); i++){
            //even
            left = i;
            right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if(right-left+1 > end){
                    start = left;
                    end = right-left+1;
                }
                left--;
                right++;
            }

            //odd
            left = i-1;
            right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                if(right-left+1 > end){
                    start = left;
                    end = right-left+1;
                }
                left--;
                right++;
            }
        }

        return s.substring(start,start+end);
    }
}