class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();

        int j=0;
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && popped[j] == stack.peek()){
                stack.pop();
                j++;
            }

            stack.push(pushed[i]);
        }

        while(!stack.isEmpty() && popped[j] == stack.peek()){
            stack.pop();
            j++;
        }

        return stack.isEmpty() && j==n;
    }
}