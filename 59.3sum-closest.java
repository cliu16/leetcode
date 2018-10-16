public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if(numbers == null || numbers.length < 3){
            return 0;
        }
        Arrays.sort(numbers);
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < numbers.length - 2; i++){
            int start = i + 1;
            int end = numbers.length - 1;
            while(start < end){
                int sum = numbers[i] + numbers[start] + numbers[end];
                if(Math.abs(sum - target) < Math.abs(target - ret)){
                    ret = sum;
                }

                if(sum == target){
                    return ret;
                }else if(sum > target){
                    end--;
                }else{
                    start++;
                }
            }
        }

        return ret;
    }
}
