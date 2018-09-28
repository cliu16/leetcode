public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int sum = 0;
        for(int i = 0; i < values.length; i++){
            sum += values[i];
        }
        return (dfs(values, new int[values.length], 0) * 2 > sum);
    }

    public int dfs(int[] values, int[] dp, int level){
        if(level >= values.length){
            return 0;
        }

        if(level == values.length - 1){
            return values[level];
        }

        if(level == values.length - 2){
            return values[level] + values[level + 1];
        }

        if(level == values.length - 3){
            return values[level] + values[level + 1];
        }

        if(dp[level] != 0){
            return dp[level];
        }

        int left = Math.min(dfs(values, dp, level + 2), dfs(values, dp, level + 3)) + values[level];
        int right = Math.min(dfs(values, dp, level + 3), dfs(values, dp, level + 4)) + values[level] + values[level + 1];

        dp[level] = Math.max(left, right);
        return dp[level];
    }
}
