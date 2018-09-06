class Solution {
    public boolean isPerfectSquare(int num) {
        long start = 0, end = (long)num;
        while(start + 1 < end){
            long mid = start + (end - start) / 2;
            long val = mid * mid;
            if(val > num){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(start * start == num || end * end == num){
            return true;
        }

        return false;
    }
}
