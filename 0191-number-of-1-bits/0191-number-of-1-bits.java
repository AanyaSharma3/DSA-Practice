class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        //32 bit
        for(int i=0; i<32; i++){
            if((n&1) == 1){ //last bit find
                count++;
            }

            n>>=1; //right shift and bit remove
        }
        return count;
    }
}