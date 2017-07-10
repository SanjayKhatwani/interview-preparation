public class Solution {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || start == null || destination == null) {
            return false;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return hasPath(maze, start, destination, visited);
    }

    private boolean hasPath(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
        int y = start[0];
        int x = start[1];
        if (visited[y][x]) return false;
        visited[y][x] = true;
        if (x == dest[1] && y == dest[0]) {
            return true;
        }
        // left
        if (x > 0 && maze[y][x-1] != 1) {
            int i = x - 1;
            while (i > 0 && maze[y][i-1] != 1) i--;
            if (hasPath(maze, new int[]{y, i}, dest, visited)) return true;
        }
        //right
        if (x < maze[0].length - 1 && maze[y][x+1] != 1) {
            int i = x + 1;
            while (i < maze[0].length-1 && maze[y][i+1] != 1)  i++;
            if (hasPath(maze, new int[]{y, i}, dest, visited)) return true;
        }
        //up
        if (y > 0 && maze[y-1][x] != 1) {
            int i = y - 1;
            while (i > 0 && maze[i-1][x] != 1) i--;
            if (hasPath(maze, new int[]{i, x}, dest, visited)) return true;
        }
        //down
        if (y < maze.length - 1 && maze[y+1][x] != 1) {
            int i = y + 1;
            while (i < maze.length-1 && maze[i+1][x] != 1) i++;
            if (hasPath(maze, new int[]{i, x}, dest, visited)) return true;
        }
        return false;
    }

}

// bfs
public class Solution {
    class Point {
        int x, y;
        public Point(int _x, int _y) {
            x = _x; 
            y = _y;
        }
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int m = maze.length, n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) 
            return true;

        int[][] dir = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        queue.offer(new Point(start[0], start[1]));

        while (!list.isEmpty()) {
            Point p = queue.poll();
            int x = p.x, y = p.y;
            for (int i = 0; i < 4; i++) {
                int xx = x, yy = y;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += dir[i][0];
                    yy += dir[i][1];
                }
                xx -= dir[i][0];
                yy -= dir[i][1];
                if (visited[xx][yy]) continue;
                visited[xx][yy] = true;
                if (xx == destination[0] && yy == destination[1]) return true;
                queue.offer(new Point(xx, yy));
            }
        }

        return false;
        
    }
}