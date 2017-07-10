public class Solution {
    class Point {
        int x, y, l;
        public Point(
            int _x, int _y, int _l) {x = _x; y = _y; l =_ l;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] length = new int[m][n]; // record length

        for (int i = 0; i < m * n; i++) 
            length[i / n][i % n] = Integer.MAX_VALUE;

        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        PriorityQueue<Point> heap = new PriorityQueue<>((o1,o2) -> o1.l - o2.l); // using priority queue
        heap.offer(new Point(start[0], start[1], 0));
        while (!heap.isEmpty()) {
            Point curr = heap.poll();
            if (length[curr.x][curr.y] <= curr.l) continue; // if we have already found a route shorter
            length[curr.x][curr.y] = curr.l;
            for (int i = 0; i < 4; i++) {
                int xx = curr.x, yy = curr.y, l = curr.l;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += dir[i][0];
                    yy += dir[i][1];
                    l++;
                }
                xx -= dir[i][0];
                yy -= dir[i][1];
                l--;
                heap.offer(new Point(xx, yy, l));
            }
        }
        return length[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : length[destination[0]][destination[1]];
    }
}
