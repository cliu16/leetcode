class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int[][] visited = new int[matrix.length][matrix[0].length];
        int ret = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(visited[i][j] == 0){
                    ret = Math.max(dfs(matrix, i, j, visited), ret);
                }
            }
        }

        return ret;
    }

    int[] DELTA_X = {0, -1, 1, 0};
    int[] DELTA_Y = {1, 0, 0, -1};
    
    private int dfs(int[][] matrix, int x, int y, int[][] visited){
        if(visited[x][y] != 0){
            return visited[x][y];
        }

        int cur = 0;
        for(int i = 0; i < 4; i++){
            int newX = x + DELTA_X[i];
            int newY = y + DELTA_Y[i];

            if(!isInbound(matrix, newX, newY)){
                continue;
            }

            if(matrix[x][y] >= matrix[newX][newY]){
                continue;
            }
            
            cur = Math.max(cur, dfs(matrix, newX, newY, visited));
        }

        cur++;
        visited[x][y] = cur;
        return cur;
    }

    private boolean isInbound(int[][] matrix, int x, int y){
        if(x < 0 || x > matrix.length - 1){
            return false;
        }

        if(y < 0 || y > matrix[0].length - 1){
            return false;
        }

        return true;
    }
}
