import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ret = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return ret;
        }
        
        boolean[][] canReachPacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] canReachAtlantic = new boolean[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            dfs(matrix, canReachPacific, i, 0, 0);
            dfs(matrix, canReachAtlantic, i, matrix[0].length - 1, 0);
        }

        for(int j = 0; j < matrix[0].length; j++){
            dfs(matrix, canReachPacific, 0, j, 0);
            dfs(matrix, canReachAtlantic, matrix.length - 1, j, 0);
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(canReachPacific[i][j] && canReachAtlantic[i][j]){
                    ret.add(new int[]{i,j});
                }
            }
        }

        return ret;
    }

    private int[] DELTA_X = {0, 1, -1, 0};
    private int[] DELTA_Y = {1, 0, 0, -1};
        
    private void dfs(int[][] matrix, boolean[][] canReach, int x, int y, int pre){
        if(!isInbound(matrix, x, y)){
            return;
        }

        if(canReach[x][y]){
            return;
        }

        if(matrix[x][y] < pre){
            return;
        }

        canReach[x][y] = true;
        for(int i = 0; i < 4; i++){
            int newX = x + DELTA_X[i];
            int newY = y + DELTA_Y[i];

            dfs(matrix, canReach, newX, newY, matrix[x][y]);
        }
    }

    private boolean isInbound(int[][] matrix, int x ,int y){
        if(x < 0 || x > matrix.length - 1){
            return false;
        }

        if(y < 0 || y > matrix[0].length - 1){
            return false;
        }

        return true;
    }
}
