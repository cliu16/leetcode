class Solution {
    class Cell{
        int x, y, h;
        public Cell(int xx, int yy, int hh){
            x = xx;
            y = yy;
            h = hh;
        }
    }

    private static final int[] DELTA_X = {0, 1, -1, 0};
    private static final int[] DELTA_Y = {-1, 0, 0, 1};
    
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0){
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        
        PriorityQueue<Cell> heap = new PriorityQueue<>(new Comparator<Cell>(){
                public int compare(Cell a, Cell b){
                    return a.h - b.h;
                }
            });

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            heap.offer(new Cell(i, 0, heightMap[i][0]));
            heap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for(int j = 0; j < n; j++){
            heap.offer(new Cell(0, j, heightMap[0][j]));
            heap.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int ret = 0;
        while(!heap.isEmpty()){
            Cell cur = heap.poll();
            for(int i = 0; i < 4; i++){
                int dx = cur.x + DELTA_X[i];
                int dy = cur.y + DELTA_Y[i];
                if(dx < 0 || dx >= m || dy < 0 || dy >= n || visited[dx][dy]){
                    continue;
                }
                int dh = heightMap[dx][dy];

                visited[dx][dy] = true;
                if(dh < cur.h){
                    ret += cur.h - dh;
                    heap.offer(new Cell(dx, dy, cur.h));
                }else{
                    heap.offer(new Cell(dx, dy, dh));
                }
            }
        }
        return ret;
    }
}
