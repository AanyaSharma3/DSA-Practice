
class Solution {
    Queue<int[]> q = new LinkedList<>();

    int[] dx = {-1, 1, 0, 0}; //direction from x
    int[] dy = {0, 0, -1, 1}; //direction from y

    //dfs 
    public void dfs(int[][] grid, int x, int y) {
        int n = grid.length; //row
        int m = grid[0].length; //col

        grid[x][y] = 2;

        // Add first island 
        q.offer(new int[]{x, y});

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; //new x
            int ny = y + dy[i]; //new y

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1) {
                dfs(grid, nx, ny);
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length; //row
        int m = grid[0].length; //col

        //find first island in bfs
        boolean found = false;

        //grid traverse
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                        continue;

                    // reached second island
                    if (grid[nx][ny] == 1) {
                        return steps;
                    }

                    //through water
                    if (grid[nx][ny] == 0) {
                        grid[nx][ny] = 2;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
