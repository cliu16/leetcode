public class Solution {
    /**
     * @param matrix: A 2D-array of integers
     * @return: an integer
     */
    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = 1;
            }
        }

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dfs(matrix, dp, visited, i, j, -1);
            }
        }
        return max;
    }

    int[] DELTA_X = {0, 1, -1, 0};
    int[] DELTA_Y = {1, 0, 0, -1};
    int max = 0;
    
    private int dfs(int[][] matrix, int[][] dp, boolean[][] visited, int x, int y, int pre){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= pre){
            return 0;
        }

        if(visited[x][y]){
            return dp[x][y];
        }

        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
            int dx = x + DELTA_X[i];
            int dy = y + DELTA_Y[i];
            dp[x][y] = Math.max(dp[x][y], 1 + dfs(matrix, dp, visited, dx, dy, matrix[x][y]));
            max = Math.max(max, dp[x][y]);
        }
        return dp[x][y];
    }
}
