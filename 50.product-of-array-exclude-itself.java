public class Solution {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        long[] tmp1 = new long[nums.size()];
        long left = 1;
        for(int i = 0; i < nums.size(); i++){
            tmp1[i] = left;
            left *= nums.get(i);
        }

        long right = 1;
        for(int i = nums.size() - 1; i >= 0; i--){
            tmp1[i] = right * tmp1[i];
            right *= nums.get(i);
        }

        List<Long> ret = new ArrayList<>();
        for(int i = 0; i < tmp1.length; i++){
            ret.add(tmp1[i]);
        }
        return ret;
    }
}
