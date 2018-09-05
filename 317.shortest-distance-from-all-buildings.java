import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private static final int WALL = 2;
    private static final int BUILDING = 1;
    private static final int EMPTY = 0;

    class Coord {
        int x, y;

        public Coord(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int minDistance = Integer.MAX_VALUE;
        int[][] distanceGrid = initDistanceGrid(grid);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == BUILDING) {
                    if (!updateDistance(grid, distanceGrid, i, j)) {
                        return -1;
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (distanceGrid[i][j] == 0) {
                    continue;
                }
                minDistance = Math.min(minDistance, distanceGrid[i][j]);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int[][] initDistanceGrid(int[][] grid) {
        int[][] ret = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ret[i][j] = 0;
            }
        }

        return ret;
    }

    // BFS
    private boolean updateDistance(int[][] grid, int[][] distanceGrid, int a, int b) {
        Queue<Coord> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.offer(new Coord(a, b));
        visited[a][b] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coord cur = queue.poll();

                if (distanceGrid[cur.x][cur.y] == Integer.MAX_VALUE) {
                    distanceGrid[cur.x][cur.y] = Integer.MAX_VALUE;
                } else {
                    distanceGrid[cur.x][cur.y] += level;
                }

                for (Coord adj : getAdjs(cur)) {
                    if (!isInbound(adj, grid)) {
                        continue;
                    }

                    if (visited[adj.x][adj.y]) {
                        continue;
                    }

                    visited[adj.x][adj.y] = true;

                    if (grid[adj.x][adj.y] != EMPTY) {
                        continue;
                    }


                    queue.offer(adj);
                }
            }
            level++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == EMPTY && !visited[i][j]) {
                    distanceGrid[i][j] = Integer.MAX_VALUE;
                }
                if (grid[i][j] == BUILDING && !visited[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[] DELTA_X = {-1, 0, 0, 1};
    private int[] DELTA_Y = {0, 1, -1, 0};

    private List<Coord> getAdjs(Coord cur) {
        List<Coord> ret = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ret.add(new Coord(cur.x + DELTA_X[i], cur.y + DELTA_Y[i]));
        }
        return ret;
    }

    private boolean isInbound(Coord cur, int[][] grid) {
        if (cur.x < 0 || cur.x > grid.length - 1) {
            return false;
        }

        if (cur.y < 0 || cur.y > grid[0].length - 1) {
            return false;
        }

        if (grid[cur.x][cur.y] == WALL) {
            return false;
        }

        return true;
    }
}
