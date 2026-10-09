class Solution {
    List<List<String>> ans;

    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;

        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    
    public void recur(List<String> curr , int i , String s , int dp[][]){
        if(s.length() == i){
            ans.add(new ArrayList<>(curr));
            return ;
        }

        for(int j=i; j<s.length(); j++){
            String dumy = s.substring(i,j+1);
            if(dp[i][j] == 1 || isPalindrome(dumy)){
                List<String> copy = new ArrayList<>(curr);
                dp[i][j] = 1;
                copy.add(s.substring(i,j+1));
                recur(copy,j+1,s,dp);
            }
        }
    }


    public List<List<String>> partition(String s) {
        int n = s.length();
        ans = new ArrayList<>();
        int dp[][] = new int[n][n];

        recur(new ArrayList<>() , 0 , s , dp);

        return ans;
    }
}