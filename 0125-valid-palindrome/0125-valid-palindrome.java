class Solution {
    public boolean isPalindrome(String s) {
       int i = 0;
       int j = s.length()-1;

       while(i<j){
          //check for spaces
          while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
            i++;
          }
          while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
            j--;
          }

          //check for palindrome
          while(i<j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
            return false;
          }
          i++;
          j--;
       }

       return true;
    }
}