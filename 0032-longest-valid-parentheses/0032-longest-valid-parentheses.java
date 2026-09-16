class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int ans = 0;

        for(int i=0; i<s.length(); i++){
            //open bracket
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                //close bracket
                if(!stack.isEmpty()){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    ans = Math.max(ans,i - stack.peek());
                }else{
                    stack.push(i);
                }
            }
        }

        return ans;
    }
}