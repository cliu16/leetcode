public class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        return dfs(n, new int[n + 1]);
    }

    private boolean dfs(int n, int[] dp){
        if(n <= 0){
            return false;
        }

        if(n <= 2){
            return true;
        }

        if(dp[n] != 0){
            return dp[n] > 0;
        }

        if((dfs(n - 2, dp) && dfs(n - 3, dp)) || (dfs(n - 3, dp) && dfs(n - 4, dp))){
            dp[n] = 1;
            return true;
        }else{
            dp[n] = -1;
            return false;
        }
    }
}
