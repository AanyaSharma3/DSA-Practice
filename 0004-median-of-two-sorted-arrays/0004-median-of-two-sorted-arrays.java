class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if(n>m){
            return findMedianSortedArrays(nums2 , nums1);
        }

        int low = 0;
        int high = n;

        while(low<=high){
            int m1 = (low+high)/2;
            int m2 = (n+m+1)/2-m1;

            double l1 = (m1==0) ? Integer.MIN_VALUE : nums1[m1-1];
            double r1 = (m1==n) ? Integer.MAX_VALUE : nums1[m1];
            double l2 = (m2==0) ? Integer.MIN_VALUE : nums2[m2-1];
            double r2 = (m2==m) ? Integer.MAX_VALUE : nums2[m2];

            if(l1<=r2 && r1>=l2){
                if((n+m)%2==0){
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
                }else{
                    return (double)(Math.max(l1,l2));
                }
            }else if(l1>r2){
                high = m1-1;
            }else{
                low = m1+1;
            }

        }

        return 0;
    }
}