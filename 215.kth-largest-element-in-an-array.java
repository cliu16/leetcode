class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return quickSearch(nums, nums.length - k + 1, 0, nums.length - 1);
    }

    private int quickSearch(int[] A, int k, int start, int end){
        if(start == end){
            return A[start];
        }

        int left = start, right = end;
        int pivot = A[start + (end - start) / 2];

        while(left <= right){
            while(left <= right && A[left] < pivot){
                left++;
            }

            while(left <= right && A[right] > pivot){
                right--;
            }

            if(left <= right){
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;

                left++;
                right--;
            }
        }

        if(start + k - 1 <= right){
            return quickSearch(A, k, start, right);
        }

        if(start + k - 1 >= left){
            return quickSearch(A, k - (left - start), left, end);
        }

        return A[right + 1];
    }
}
