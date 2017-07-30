public class Solution {
    class Cell {
        int h;
        int x, y;
        public Cell(int h, int x, int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0)
            return 0;
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.h - b.h);
        for (int i = 0; i < n; i++) {
            visited[i][0] = true;
            visited[i][m-1] = true;
            pq.offer(new Cell(heightMap[i][0], i, 0));
            pq.offer(new Cell(heightMap[i][m-1], i, m-1));
        }
        for (int i = 1; i < m - 1; i++) {
            visited[0][i] = true;
            visited[n-1][i] = true;
            pq.offer(new Cell(heightMap[0][i], 0, i));
            pq.offer(new Cell(heightMap[n-1][i], n-1, i));
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int capacity = 0;
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int i = 0; i < 4; i++) {
                int x = cell.x + dx[i];
                int y = cell.y + dy[i];
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) 
                    continue;
                capacity += Math.max(0, cell.h - heightMap[x][y]);
                visited[x][y] = true;
                pq.offer(new Cell(Math.max(cell.h, heightMap[x][y]), x, y));
            }
        }
        return capacity;
    }
}