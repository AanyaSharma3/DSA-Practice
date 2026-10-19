class Solution {
    public int myAtoi(String s) {
        int i=0;
        int ans = 0;
        int sign = 1;

        while(i<s.length() && s.charAt(i)==' '){
            i++;
        } 

        if(i == s.length()){
            return 0;
        }

        if(i<s.length() && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }else if(i<s.length() && s.charAt(i) == '+'){
            i++;
        }

        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int num = s.charAt(i)-'0';

            if(ans>Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && num>Integer.MAX_VALUE%10)){
                if(sign == -1) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }

            ans = ans * 10+num;
            i++;
        }

        return sign*ans;
    }
}