class CustomStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int currsize;
    int maxsize;

    public CustomStack(int maxSize) {
        //constructor
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        currsize = 0;
        maxsize = maxSize;
    }
    
    public void push(int x) {
        if(currsize < maxsize){
            stack1.push(x);
            currsize++;
        }
    }
    
    public int pop() {
        if(currsize == 0){
            return -1;
        }
        currsize--;
        return stack1.pop();
    }
    
    public void increment(int k, int val) {
        while(stack1.size() != 0){
            stack2.push(stack1.pop());
        }

        while(stack2.size() != 0 && (k>0)){
            stack1.push(stack2.pop()+val);
            k--;
        }

        while(stack2.size() != 0){
            stack1.push(stack2.pop());
        }
    }


}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */