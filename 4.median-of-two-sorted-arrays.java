class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if(total % 2 == 0){
            return (findKth(nums1, nums2,  0, 0, total / 2) + findKth(nums1, nums2, 0, 0, total / 2 + 1)) / 2.0;
        }else{
            return findKth(nums1, nums2, 0, 0, total / 2 + 1);
        }
    }

    // K is not index, k >= 1
    private int findKth(int[] A, int[] B, int idxA, int idxB, int k){
        if(idxA >= A.length){
            return B[idxB + k - 1];
        }

        if(idxB >= B.length){
            return A[idxA + k - 1];
        }

        if(k == 1){
            return Math.min(A[idxA], B[idxB]);
        }

        int valA = Integer.MAX_VALUE;
        int valB = Integer.MAX_VALUE;


        //the [k / 2 - 1] of A and B 
        if(idxA + k / 2 - 1 < A.length){
            valA = A[idxA + k /2 - 1];
        }

        if(idxB + k / 2 - 1 < B.length){
            valB = B[idxB + k /2 - 1];
        }


        // drop (k / 2) from a or b
        if(valA < valB){
            return findKth(A, B, idxA + k / 2, idxB, k - k / 2);
        }else{
            return findKth(A, B, idxA, idxB + k / 2, k - k / 2);
        }
    }
}
