class NumArray {
    int tree[];
    int nums[];
    int n;

    //Creation of ST
    public int buildST(int nums[],int sti,int start,int end){
        if(start == end){
            tree[sti] = nums[start];
            return nums[start];
        }

       int mid = (start+end)/2;
       int left = buildST(nums, 2*sti+1, start, mid);
       int right = buildST(nums, 2*sti+2, mid+1, end);
       tree[sti] = left+right;
       return tree[sti];
    }

    public NumArray(int[] nums) {
        this.nums = nums;
       this.n = nums.length;
        tree = new int[4*n];

        buildST(nums,0,0,n-1);
    }
    
    //Update function
    public void updateUtil(int i,int si,int sj,int index,int diff){
        if(si>index || sj<index){
            return ;
        }

        tree[i] += diff;
        if(si != sj){
        int mid = (si+sj)/2;
        updateUtil(2*i+1,si,mid,index,diff);
        updateUtil(2*i+2,mid+1,sj,index,diff);
        }

    }

    public void update(int index, int val) {
        //array update
        int diff = val - nums[index];
        nums[index] = val;

        updateUtil(0,0,n-1,index,diff);
    }
    
    //query
    public int query(int i,int si,int sj,int qi,int qj){
        //non-overlap
       if(si>qj || qi>sj){
            return 0;
        }
        //case-2 overlap
        else if(si>=qi && sj<=qj){
            return tree[i];
        }
        else{
            //case-3 partial overlap
            int mid = (si+sj)/2;
            int left = query(2*i+1,si,mid,qi,qj);
            int right = query(2*i+2,mid+1,sj,qi,qj);
            return left+right;
        }
    }

    public int sumRange(int left, int right) {
       return query(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */